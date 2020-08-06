package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ五种工作模式之四：路由模式，一个生产者，多个消费者接收任务，通过路由键指定接收消息的消费者(info.error)，
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo04RoutingQueueSendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        for (int i = 0; i < 1000; i++) {
            /**
             * 参数1：设置交换机
             * 参数2：设置路由键，路由模式，设置路由键(error，info)
             * 参数3：设置发送的消息内容
             */
            if(i%2 == 0){
                rabbitTemplate.convertAndSend("routing_exchange","info","[info]你太坏了，小兔子【"+i+"】");
            } else {
                rabbitTemplate.convertAndSend("routing_exchange","error","[error]你太坏了，小兔子【"+i+"】");
            }
        }
    }
}
