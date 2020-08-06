package com.changgou.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {


    //延迟消息队列名称
    public static final String RELAY_QUEUE = "relay_queue";
    //交换机名称
    public static final String CANCEL_ORDER_PAY_EXCHANGE = "cancel_order_pay_exchange";

    //队列名称
    public static final String CANCEL_ORDER_QUEUE = "cancel_order_queue";

    /**
     * 创建延迟消息队列
     * 并且配置对应的死信交换器名称
     * @return
     */
    @Bean
    public Queue relayQueue(){
        return QueueBuilder.durable(RELAY_QUEUE)
                .withArgument("x-dead-letter-exchange",CANCEL_ORDER_PAY_EXCHANGE)
                .withArgument("x-dead-letter-routing-key","")
                .build();
    }


    /**
     * 创建队列, 死信队列
     * @return
     */
    @Bean
    public Queue cancelOrderQueue(){
        return new Queue(CANCEL_ORDER_QUEUE);
    }

    /**
     * 创建交换器, 死信交换器, 定向发送
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(CANCEL_ORDER_PAY_EXCHANGE);
    }

    /**
     * 配置绑定关系
     * 将死信交换器和死信队列绑定在一起
     * @return
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(cancelOrderQueue()).to(directExchange()).with("");
    }


}
