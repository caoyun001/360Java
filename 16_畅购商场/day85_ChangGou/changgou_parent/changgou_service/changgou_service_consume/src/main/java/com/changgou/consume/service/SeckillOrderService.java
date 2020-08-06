package com.changgou.consume.service;

import com.changgou.seckill.pojo.SeckillOrder;

/**
 *
 */
public interface SeckillOrderService {

    /**
     * 保存秒杀订单到数据库, 并且扣减数据库中秒杀商品库存
     * @param seckillOrder
     * @return
     */
    public boolean saveSeckillOrderToDB(SeckillOrder seckillOrder);
}
