package com.chongba.job;

import com.chongba.entity.Constants;
import com.chongba.entity.ResponseMessage;
import com.chongba.feign.TaskServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by 传智播客*黑马程序员.
 */
@Service
@Slf4j
public class JobService {
    
    @Autowired
    private TaskServiceClient taskServiceClient;
    
    @Autowired
    private SelectMaster selectMaster;
    
    @PostConstruct
    public void init(){
        //进行选主
        selectMaster.selectMaster(Constants.job_leaderPath);
    }
    
    @Scheduled(cron = "*/1 * * * * ?")
    public void refresh(){
        
        //判断---只有主节点才能进行定时刷新的调度
        boolean master = selectMaster.checkMaster(Constants.job_leaderPath);
        if(master){
            log.info("job 主节点进行定时刷新调度");
            //主节点
            try {
                ResponseMessage refresh = taskServiceClient.refresh();
                log.info("refresh {}",refresh);
            } catch (Exception e) {
                log.error("refresh exception,msg={}",e.getMessage());
            }
        }else {
            //从节点
            log.info("job 从节点进行备份");
        }
       
    }
}
