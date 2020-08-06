package com.changgou.seckill.config;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 自定义消息发送类
 * 增强RabbitTemplate
 * @author ZJ
 */
@Component
public class CustomMessageSender implements RabbitTemplate.ConfirmCallback{

    static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    //redis中存储发送失败的消息的key
    private static final String MESSAGE_CONFIRM_="message_confirm_";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 构造方法
     * @param rabbitTemplate
     */
    public CustomMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 生产者通知回调方法
     * @param correlationData 唯一标识
     * @param ack 成功/失败
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack){
            //返回成功通知
            //删除redis中的相关数据
            redisTemplate.delete(correlationData.getId());
            redisTemplate.delete(MESSAGE_CONFIRM_+correlationData.getId());
        }else{
            //返回失败通知
            Map<String,String> map =(Map<String,String>)redisTemplate.opsForHash().entries(MESSAGE_CONFIRM_ + correlationData.getId());
            String exchange = map.get("exchange");
            String routingKey = map.get("routingKey");
            String sendMessage = map.get("sendMessage");

            //重新发送
            rabbitTemplate.convertAndSend(exchange,routingKey, JSON.toJSONString(sendMessage));
        }
    }

    /**
     * 自定义发送方法
     * @param exchange      交换器
     * @param routingKey    路由键
     * @param message       消息内容
     */
    public void sendMessage(String exchange,String routingKey,String message){

        //设置消息唯一标识并存入缓存
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        redisTemplate.opsForValue().set(correlationData.getId(),message);

        //本次发送到相关元信息存入缓存
        Map<String, String> map = new HashMap<>();
        map.put("exchange", exchange);
        map.put("routingKey", routingKey);
        map.put("sendMessage", message);
        redisTemplate.opsForHash().putAll(MESSAGE_CONFIRM_+correlationData.getId(), map);

        //携带唯一标识发送消息
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
    }
}
