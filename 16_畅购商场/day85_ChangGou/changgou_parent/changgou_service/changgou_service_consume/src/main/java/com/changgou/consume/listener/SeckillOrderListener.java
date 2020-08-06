package com.changgou.consume.listener;

import com.alibaba.fastjson.JSON;
import com.changgou.consume.config.RabbitMQConfig;
import com.changgou.consume.service.SeckillOrderService;
import com.changgou.seckill.pojo.SeckillOrder;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *
 */
@Component
public class SeckillOrderListener {

    @Autowired
    private SeckillOrderService seckillOrderService;

    /**
     * 由于使用了ACK手动确认机制, 监听器接受下面参数
     * @param channel   通道, 传递消息的通道对象, 因为我们给rabbitMq手动返回是否接受到消息的通知, 需要使用
     * @param message   消息, 也就是rabbitMq服务器, 发送来的内容
     */
    @RabbitListener(queues = RabbitMQConfig.SECKILL_ORDER)
    public void messageHandler(Channel channel, Message message) {

        try {

            //消峰, 一次取三百个消息, 取出后执行下面的业务
            channel.basicQos(300);

            //从消息对象中获取消息体
            byte[] body = message.getBody();
            //将byte数组类型的消息体, 转换成秒杀订单json格式字符串
            String seckillOrderJsonStr = new String(body);
            //将json转换成秒杀订单对象
            SeckillOrder seckillOrder = JSON.parseObject(seckillOrderJsonStr, SeckillOrder.class);
            //调用service, 保存秒杀订单到数据库, 并且扣减秒杀商品库存
            boolean flag = seckillOrderService.saveSeckillOrderToDB(seckillOrder);

            if (flag) {
                /**
                 * 更新数据库操作成功
                 * 消费者发起成功通知
                 * DeliveryTag: 消息的唯一标识  channel+消息编号
                 * 第二个参数：是否开启批量处理 false:不开启批量
                 */
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                /**
                 * 返回失败通知
                 * 第一个boolean true所有消费者都会拒绝这个消息，false代表只有当前消费者拒绝
                 * 第二个boolean true当前消息会进入到死信队列，false重新回到原有队列中，默认回到头部
                 */
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            }


        } catch (Exception e) {
            e.printStackTrace();
            /**
             * 返回失败通知
             * 第一个boolean true所有消费者都会拒绝这个消息，false代表只有当前消费者拒绝
             * 第二个boolean true当前消息会进入到死信队列，false重新回到原有队列中，默认回到头部
             */
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }
}
