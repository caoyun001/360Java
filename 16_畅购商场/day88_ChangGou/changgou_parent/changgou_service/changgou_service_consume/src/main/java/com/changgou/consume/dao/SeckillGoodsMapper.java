package com.changgou.consume.dao;

import com.changgou.seckill.pojo.SeckillGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;


public interface SeckillGoodsMapper extends Mapper<SeckillGoods> {

    /**
     * 扣减库存
     * @param id   扣减库存的秒杀商品id
     * @return
     */
    @Update("update tb_seckill_goods set stock_count = stock_count-1 where id=#{id}")
    public int decrStockCount(@Param("id") Long id);

}
