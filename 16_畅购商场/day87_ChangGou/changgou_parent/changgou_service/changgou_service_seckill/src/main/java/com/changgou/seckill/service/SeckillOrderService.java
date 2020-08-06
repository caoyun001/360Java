package com.changgou.seckill.service;

/**
 *
 */
public interface SeckillOrderService {

    /**
     * 秒杀下单
     * @param id    秒杀商品id
     * @param time  时间菜单
     * @param userName  购买人的用户名
     * @return
     */
    public boolean add(String id, String time, String userName);
}
