package com.changgou.seckill.task;

import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import com.changgou.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *  定时器, 定时执行, 加载mysql中秒杀商品数据到redis中
 */
@Component
public class PullSeckillGoodsToRedis {

    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定时器每20秒执行一次
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void pushGoodsToRedis() {
        //1）获取秒杀时间段菜单信息, 一天分为12个秒杀场次菜单, 两个小时为一场, 这里显示以当前时间开始计算的五场
        List<Date> dateMenus = DateUtil.getDateMenus();
        //2）遍历每一个时间段，添加该时间段下秒杀商品
        for (Date dateMenu : dateMenus) {
            // 2.1）将当前时间段转换为String，作为redis中的key
            String redisExtName = DateUtil.date2Str(dateMenu);

            /**
             * 从redis中获取已经存在的所有秒杀商品id, 将这些id存入sql语句, 在查询的时候不查询出来
             */
            Set seckillGoodsIds = redisTemplate.boundHashOps(redisExtName).keys();

            // 2.2）查询商品信息（状态为1，库存大于0，秒杀商品开始时间大于当前时间段，秒杀商品结束时间小于当前时间段，当前商品的id不在redis中
            List<SeckillGoods> seckillGoodsList = seckillGoodsService.findSeckillGoodsByTime(dateMenu, seckillGoodsIds);

            /**
             * 3）添加redis
             * 保存到redis中的秒杀商品集合数据格式如下:
             *     2020020710秒杀商品时间菜单作为大key  :   Hash
             *                                            秒杀商品id作为小key ,  秒杀商品对象作为value
             */
            if (seckillGoodsList != null && seckillGoodsList.size() > 0) {
                for (SeckillGoods seckillGoods : seckillGoodsList) {
                    //将秒杀商品存入redis中
                    redisTemplate.boundHashOps(redisExtName).put(String.valueOf(seckillGoods.getId()), seckillGoods);

                    //将秒杀商品库存量存单独存入redis中, 秒杀下单扣减库存的时候使用.
                    //如果直接到mysql中扣减库存, 容易发生mysql高并发写入宕机, 容易发生超卖
                    /**
                     *  redis中的redisTemplate.boundValueOps()API 锁是有bug的, 所以使用redisTemplate.opsForValue()这一套API
                     *  目的是在扣减库存的时候, 会用到里面的原子锁, 锁库存, 再扣减, 防止超卖
                     */
                    redisTemplate.opsForValue().set(String.valueOf(seckillGoods.getId()), seckillGoods.getStockCount());
                }

            }

        }
    }
}
