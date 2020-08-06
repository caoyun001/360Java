package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ五种工作模式之二：工作队列，一个生产者，多个消费者接收任务
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02WorkQueueSendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        for (int i = 0; i < 1000; i++) {
            //循环一千次，用工作队列发送请求
            rabbitTemplate.convertAndSend("work_queue","你太好了，小兔子【"+i+"】");
        }
    }
}
