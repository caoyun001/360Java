package com.changgou.seckill.service;

import com.changgou.seckill.dao.SeckillGoodsMapper;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.util.DateUtil;
import javafx.scene.shape.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<SeckillGoods> findSeckillGoodsByTime(Date dateMenu, Set seckillGoodsIds) {
        //创建查询对象
        Example example = new Example(SeckillGoods.class);
        //创建sql语句where条件对象
        Example.Criteria criteria = example.createCriteria();
        //设置条件, 秒杀商品审核通过的
        criteria.andEqualTo("status", "1");
        //设置条件, 剩余库存量大于0
        criteria.andGreaterThan("stockCount", 0);
        //设置条件, 秒杀起始时间 大于等于时间菜单
        criteria.andGreaterThanOrEqualTo("startTime", dateMenu);
        //设置条件, 秒杀结束时间  小于时间菜单+2小时
        Date endTime = DateUtil.addDateHour(dateMenu, 2);
        criteria.andLessThan("endTime", endTime);

        //设置条件, redis中已经存在的秒杀商品不应该被查询出来
        if (seckillGoodsIds != null && seckillGoodsIds.size() > 0 ){
            criteria.andNotIn("id", seckillGoodsIds);
        }

        List<SeckillGoods> seckillGoodsList = seckillGoodsMapper.selectByExample(example);
        return seckillGoodsList;
    }

    @Override
    public List<SeckillGoods> findSeckillGoodsListFromRedis(String time) {
        //将页面传入的时间菜单, 进行格式转换
        String dateMenu = DateUtil.formatStr(time);


        //到redis中获取秒杀商品列表数据
        List<SeckillGoods> seckillGoodsList = redisTemplate.boundHashOps(dateMenu).values();

        //到redis中获取秒杀商品库存
        if (seckillGoodsList != null) {
            for (SeckillGoods seckillGoods : seckillGoodsList) {
                //到redis中获取商品最新的剩余库存数据量
                String stockCountStr = String.valueOf(redisTemplate.opsForValue().get(String.valueOf(seckillGoods.getId())));
                //将最新的商品剩余库存放入秒杀商品对象中
                seckillGoods.setStockCount(Integer.parseInt(stockCountStr));
            }
        }
        return seckillGoodsList;
    }
}
