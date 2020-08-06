package com.changgou.seckill.service;

import com.changgou.seckill.pojo.SeckillGoods;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 */
public interface SeckillGoodsService {

    /**
     * 根据秒杀时间菜单, 到数据库中查询符合条件的秒杀商品数据
     * @param dateMenu  时间菜单
     * @param seckillGoodsIds   redis中已经存在的秒杀商品id集合
     * @return
     */
    public List<SeckillGoods> findSeckillGoodsByTime(Date dateMenu, Set seckillGoodsIds);

    /**
     * 根据时间菜单, 到redis中查询秒杀商品列表数据
     * @param time
     * @return
     */
    public List<SeckillGoods> findSeckillGoodsListFromRedis(String time);
}
