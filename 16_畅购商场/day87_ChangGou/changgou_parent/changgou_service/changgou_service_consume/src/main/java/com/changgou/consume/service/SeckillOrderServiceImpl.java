package com.changgou.consume.service;

import com.changgou.consume.dao.SeckillGoodsMapper;
import com.changgou.consume.dao.SeckillOrderMapper;
import com.changgou.seckill.pojo.SeckillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class SeckillOrderServiceImpl implements  SeckillOrderService {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    @Transactional
    public boolean saveSeckillOrderToDB(SeckillOrder seckillOrder) {

        //1. 保存秒杀订单对象到数据库
        int count = seckillOrderMapper.insertSelective(seckillOrder);
        if (count == 0) {
            throw new RuntimeException("保存秒杀订单对象失败");
        }

        //2. 扣减数据库中秒杀商品对象中的库存
        count = seckillGoodsMapper.decrStockCount(seckillOrder.getSeckillId());
        if (count == 0) {
            throw new RuntimeException("数据库扣减库存失败, 秒杀商品id:" + seckillOrder.getSeckillId());
        }
        return true;
    }
}
