package com.chongba.supplier.listener;

import com.chongba.recharge.RechargeRequest;
import com.chongba.supplier.inf.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 传智播客*黑马程序员.
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "pay",consumerGroup = "order-paid-consumer")
public class PayRocketListener implements RocketMQListener<RechargeRequest>{

    @Autowired
    private SupplierService supplierService;

    /**
     * 监听消息:
     * @param rechargeRequest
     */
    @Override
    public void onMessage(RechargeRequest rechargeRequest) {
        log.info("PayRocketListener 监听到了消息,{}",rechargeRequest);
        supplierService.recharge(rechargeRequest);
    }
}
