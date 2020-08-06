package com.changgou.seckill.service;

import com.alibaba.fastjson.JSON;
import com.changgou.seckill.config.CustomMessageSender;
import com.changgou.seckill.config.RabbitMQConfig;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 *
 */
@Service
public class SeckillOrderServiceImpl implements  SeckillOrderService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CustomMessageSender customMessageSender;


    @Override
    public boolean add(String id, String time, String userName) {
        //1.获取秒杀商品数据与库存量数据，如果没有库存则抛出异常
        //获取秒杀商品对象
        SeckillGoods seckillGoods = (SeckillGoods)redisTemplate.boundHashOps(time).get(id);
        if (seckillGoods == null) {
            return false;
        }
        //获取秒杀库存数据对象
        String stockCountStr = String.valueOf(redisTemplate.opsForValue().get(id));
        if (StringUtils.isEmpty(stockCountStr)) {
            return false;
        }
        int stockCount = Integer.parseInt(stockCountStr);
        //如果库存小于等于0, 下单失败
        if (stockCount <= 0) {
            return false;
        }
        //2.预扣减库存，如果扣完库存量<0，删除商品数据与库存数据
        Long decrement = redisTemplate.opsForValue().decrement(id);
        //判断扣减库存后, 如果库存量小于0, 则下单失败
        if (decrement < 0) {
            return false;
        }

        //3.如果库存量>=0，创建秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        //秒杀订单id
        seckillOrder.setId(idWorker.nextId());
        //支付状态 默认0未支付
        seckillOrder.setStatus("0");
        //购买金额
        seckillOrder.setMoney(seckillGoods.getCostPrice());
        //购买人用户名
        seckillOrder.setUserId(userName);
        //购买的商品id
        seckillOrder.setSeckillId(Long.parseLong(id));
        //创建时间
        seckillOrder.setCreateTime(new Date());

        //将秒杀订单对象转换为json格式字符串
        String seckillOrderJsonStr = JSON.toJSONString(seckillOrder);

        //4. 将秒杀订单对象转换成 json 发送给MQ, 基于mq异步方式完成与mysql数据同步（最终一致性）
        customMessageSender.sendMessage("", RabbitMQConfig.SECKILL_ORDER, seckillOrderJsonStr);
        return true;
    }
}
