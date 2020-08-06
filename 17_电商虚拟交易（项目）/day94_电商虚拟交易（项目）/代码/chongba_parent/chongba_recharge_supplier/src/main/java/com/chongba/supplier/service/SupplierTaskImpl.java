package com.chongba.supplier.service;

import com.alibaba.fastjson.JSON;
import com.chongba.entity.ResponseMessage;
import com.chongba.entity.Task;
import com.chongba.enums.TaskTypeEnum;
import com.chongba.feign.TaskServiceClient;
import com.chongba.recharge.RechargeRequest;
import com.chongba.supplier.inf.SupplierService;
import com.chongba.supplier.inf.SupplierTask;
import com.chongba.utils.ProtostuffUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by 传智播客*黑马程序员.
 */
@Service
@Slf4j
public class SupplierTaskImpl implements SupplierTask {
    
    @Autowired
    private TaskServiceClient taskServiceClient;
    
    @Override
    public void addRetryTask(RechargeRequest rechargeRequest) {
        //创建任务对象
        Task task  = new Task();
        TaskTypeEnum taskTypeEnum = TaskTypeEnum.getTaskType(rechargeRequest.getErrorCode());
        task.setTaskType(taskTypeEnum.getTaskType());
        task.setPriority(taskTypeEnum.getPriority());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,0);//为了方便测试---立即执行
        task.setExecuteTime(calendar.getTimeInMillis());

        task.setParameters(ProtostuffUtil.serialize(rechargeRequest));

        log.info("addRetryTask {},task={}",taskTypeEnum.getDesc(),task);
        taskServiceClient.push(task);
    }

    @Autowired
    private SupplierService supplierService;
    
    @Override
    @Scheduled(fixedRate = 1000)
    public void retryRecharge() {
        retry(TaskTypeEnum.ORDER_REQ_FAILED);
    }

    @Override
    @Scheduled(fixedRate = 1000)
    public void roundRecharge() {
        retry(TaskTypeEnum.BALANCE_NOT_ENOUGH);
    }


    private void retry(TaskTypeEnum taskTypeEnum){
        ResponseMessage responseMessage = taskServiceClient.poll(taskTypeEnum.getTaskType(), taskTypeEnum.getPriority());
        if(responseMessage.isFlag()){
            if(responseMessage.getData() !=null){
                String task_json = JSON.toJSONString(responseMessage.getData());
                Task task = JSON.parseObject(task_json, Task.class);
                RechargeRequest rechargeRequest = ProtostuffUtil.deserialize(task.getParameters(), RechargeRequest.class);
                rechargeRequest.setRepeat(rechargeRequest.getRepeat()+1);
                log.info("retryRecharge,{},rechargeRequest={}",taskTypeEnum.getDesc(),rechargeRequest);
                //进行接口重试对接
                supplierService.recharge(rechargeRequest);
            }
        }
    }


    @Override
    @Scheduled(fixedRate = 1000)
    public void rechargeException() {
        retry(TaskTypeEnum.REMOTEERROR);
    }
}
