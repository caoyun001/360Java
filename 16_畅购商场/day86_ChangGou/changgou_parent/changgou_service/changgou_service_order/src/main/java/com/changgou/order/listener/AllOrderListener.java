package com.changgou.order.listener;

import com.changgou.config.RabbitMQConfig;
import com.changgou.order.pojo.Order;
import com.changgou.order.service.OrderService;
import com.changgou.pay.feign.PayFeign;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  监听所有订单, 做超时处理
 *  如果在rabbitmq配置界面手动配置的队列, 交换器等, 那么@RabbitListener注解写到类上面
 *  如果rabbitMq的队列, 交换器等使用代码进行创建, 那么@RabbitListener注解写到方法上
 */
@Component
public class AllOrderListener {

    @Autowired
    private PayFeign payFeign;

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = RabbitMQConfig.CANCEL_ORDER_QUEUE)
    public void messageHandler(String orderId) {
        //1. 通过订单id, 调用微信查询接口, 查询支付状态
        Map wxResultMap = payFeign.queryPayStatus(orderId);
        if (wxResultMap != null) {

            //2. 如果微信返回支付成功
            if ("SUCCESS".equals(wxResultMap.get("trade_state"))) {
                //3. 根据订单id到mysql数据库中查询订单状态
                Order order = orderService.findById(orderId);
                //4. 如果mysql中的订单状态是未支付, 则进行支付成功业务补偿处理
                if ("0".equals(order.getPayStatus())) {
                    orderService.paySuccesOrder(String.valueOf(wxResultMap.get("transaction_id")), orderId);
                }
            }

            //5. 如果微信给我返回的状态是未支付
            if ("NOTPAY".equals(wxResultMap.get("trade_state"))) {
                //6. 做订单超时业务处理
                orderService.payCancelOrder(orderId);
            }
        }
    }
}
