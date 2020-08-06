package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RabbitMQ五种工作模式之五：通配符模式，一个生产者，多个消费者接收任务
 * 通过路由键指定接收消息的消费者(info.error)，路由键不是字符串，而是字符串带着通配符 *  #
 * 通篇符#，匹配一个或多个词，每个词之间是点分隔
 * 通配符*，仅仅只匹配一个词
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05TopicQueueSendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        /**
         * 参数1：设置交换机
         * 参数2：设置路由键，通配符模式，设置路由键(item.#，item.*)
         * 参数3：设置发送的消息内容
         */
        rabbitTemplate.convertAndSend("topic_exchange","item.update","路由键[item.update]你太坏了，小兔子");
        rabbitTemplate.convertAndSend("topic_exchange","item.insert.abc","路由键[item.insert.abc]你太坏了，小兔子");
    }
}
