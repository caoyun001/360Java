package com.changgou.order.listener;

import com.changgou.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 支付成功后订单业务处理
 */
@Component
@RabbitListener(queues = "order_pay")
public class PaySuccessListener {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void messageHandler(Map<String, String> wxResultMap) {
        //支付成功后微信的交易流水号
        String transaction_id = wxResultMap.get("transaction_id");
        //支付成功的订单号
        String out_trade_no = wxResultMap.get("out_trade_no");

        //做支付成功业务处理
        orderService.paySuccesOrder(transaction_id, out_trade_no);
    }
}
