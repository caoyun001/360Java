package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ五种工作模式之三：发布订阅模式(广播模式)，一个生产者，多个消费者接收任务，每个消费者都接到相同的消息，
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03PubAndSubQueueSendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        for (int i = 0; i < 1000; i++) {
            /**
             * 参数1：设置交换机
             * 参数2：设置路由键，广播模式，不设置路由键，默认是空字符串
             * 参数3：设置发送的消息内容
             */
            rabbitTemplate.convertAndSend("fanout_exchange","","你太坏了，小兔子【"+i+"】");
        }
    }
}
