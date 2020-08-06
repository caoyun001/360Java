package com.chongba.supplier.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chongba.cache.CacheService;
import com.chongba.entity.Constants;
import com.chongba.entity.StatusCode;
import com.chongba.entity.order.Result;
import com.chongba.enums.OrderStatusEnum;
import com.chongba.recharge.RechargeRequest;
import com.chongba.recharge.RechargeResponse;
import com.chongba.recharge.entity.OrderTrade;
import com.chongba.recharge.mapper.OrderTradeMapper;
import com.chongba.supplier.conf.SupplierConfig;
import com.chongba.supplier.inf.SupplierService;
import com.chongba.supplier.inf.SupplierTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.sound.midi.Soundbank;
import java.util.Set;

/**
 * Created by 传智播客*黑马程序员.
 */
@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    
    @Autowired
    private SupplierConfig supplierConfig;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private SupplierTask supplierTask;
    @Autowired
    private CacheService cacheService;
    
    @PostConstruct
    public void init(){
        log.info("加载到的配置:{}",supplierConfig);
    }
    
    @Override
    public void recharge(RechargeRequest rechargeRequest) {
        //判断重试次数
        if(rechargeRequest.getRepeat() > supplierConfig.getMaxrepeat()){
            //结束重试-----修改订单：失败
            updateTrade(rechargeRequest.getOrderNo(), OrderStatusEnum.FAIL.getCode());
            return;
        }
        
        String supplier = checkSupply(rechargeRequest.getSupply());
        if(supplier!=null){
            rechargeRequest.setSupply(supplier);
        }else {
            //没有可用的供应商了
            updateTrade(rechargeRequest.getOrderNo(), OrderStatusEnum.FAIL.getCode());
            return;
        }
        Result<RechargeResponse> result = null;
        try {
            result = doDispatchSupplier(rechargeRequest);
        } catch (Exception e) {
            log.error("recharge exception,msg={}",e.getMessage());
            //添加一个远程调用失败的重试任务
            rechargeRequest.setErrorCode(StatusCode.REMOTEERROR);
            supplierTask.addRetryTask(rechargeRequest);
            return;
        }
        if(result!=null){
            //判断对接成功还是失败
            if(result.getCode() == StatusCode.OK){
                log.info("recharge 成功");
                //特别注意此时订单状态还不能修改为充值成功-----供应商回调之后才能修改为成功
                updateTrade(rechargeRequest.getOrderNo(),OrderStatusEnum.UNAFFIRM.getCode());//充值处理中等待确认
                return;
            }else {
                //对接失败---好多原因
                if(result.getCode() == StatusCode.ORDER_REQ_FAILED){
                    // 充值下单请求失败--重试
                    rechargeRequest.setErrorCode(StatusCode.ORDER_REQ_FAILED);
                }else if(result.getCode() == StatusCode.BALANCE_NOT_ENOUGH){
                    //将当前不可用的供应商编号存储起来---排除
                    cacheService.sAdd(Constants.exclude_supplier,rechargeRequest.getSupply());
                    //获取一个可用的供应商编号
                    String supply = nextSupply();
                    log.info("轮转到新的供应商编号{}",supply);
                    if(supply!=null){
                        //余额不足---供应商轮转操作---轮转到极速
                        rechargeRequest.setSupply(supply);
                        rechargeRequest.setRepeat(0);
                        rechargeRequest.setErrorCode(StatusCode.BALANCE_NOT_ENOUGH);
                    }else {
                        //没有可用的供应商了----修改订单的状态
                        updateTrade(rechargeRequest.getOrderNo(), OrderStatusEnum.FAIL.getCode());
                        return;
                    }
                }
                //添加一个重试任务
                supplierTask.addRetryTask(rechargeRequest);
            }
        }
    }

    private String checkSupply(String supply) {
        //所有已经排除的编号
        Set<String> excludes = cacheService.setMembers(Constants.exclude_supplier);
        if(excludes.contains(supply)){
            return nextSupply();
        }else {
            return supply;
        }
    }

    private String nextSupply() {
        //所有已经排除的编号
        Set<String> excludes = cacheService.setMembers(Constants.exclude_supplier);
        for(String supply : supplierConfig.getApis().keySet()){
            if(!excludes.contains(supply)){
                return supply;
            }
        }
        return null;
    }

    /**
     * 根据不同的供应商转发不同的对接逻辑
     * @param rechargeRequest
     */
    private Result<RechargeResponse> doDispatchSupplier(RechargeRequest rechargeRequest) {
        //设置供应商的接口地址
        String url = supplierConfig.getApis().get(rechargeRequest.getSupply());
        rechargeRequest.setRechargeUrl(url);
        //根据供应商编号进行对接逻辑的分发
        if(Constants.juheapi.equals(rechargeRequest.getSupply())){
            //对接聚合
            return  doPostJuhe(rechargeRequest);
        }else if(Constants.jisuapi.equals(rechargeRequest.getSupply())){
            //对接极速
            return doPostJisu(rechargeRequest);
        }
        return null;
    }

    
    private Result<RechargeResponse> doPostJuhe(RechargeRequest rechargeRequest) {
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //创建请求实体对象
        HttpEntity entity = new HttpEntity(JSON.toJSONString(rechargeRequest),headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(rechargeRequest.getRechargeUrl(), entity, String.class);
        /*String body = responseEntity.getBody();
        Result result = JSON.parseObject(body, Result.class);*/
        Result<RechargeResponse> result = JSON.parseObject(responseEntity.getBody(), new TypeReference<Result<RechargeResponse>>(){});
        return result;
    }
    
    private Result<RechargeResponse> doPostJisu(RechargeRequest rechargeRequest) {
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //设置表单参数
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("mobile",rechargeRequest.getMobile());
        map.add("amount",rechargeRequest.getPamt()+"");
        map.add("outorderNo", rechargeRequest.getOrderNo());
        map.add("repeat", ""+rechargeRequest.getRepeat());
        //模拟请求失败
        map.add("req_status", ""+StatusCode.OK);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(rechargeRequest.getRechargeUrl(), requestEntity , String.class);
        //转换成统一对象
        Result<RechargeResponse> result= JSON.parseObject(responseEntity.getBody(), new TypeReference<Result<RechargeResponse>>(){});
        return result;
    }




    @Autowired
    private OrderTradeMapper orderTradeMapper;
    private void updateTrade(String  orderNo, int orderStatus) {
        //修改订单状态
        QueryWrapper<OrderTrade> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_no", orderNo);
        OrderTrade orderTrade = orderTradeMapper.selectOne(queryWrapper);
        if(orderTrade!=null) {
            orderTrade.setOrderStatus(orderStatus);
            orderTradeMapper.updateById(orderTrade);
        }
    }

}
