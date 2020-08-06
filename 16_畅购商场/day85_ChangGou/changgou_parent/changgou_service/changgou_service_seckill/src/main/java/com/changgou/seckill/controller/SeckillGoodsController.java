package com.changgou.seckill.controller;

import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.seckill.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/seckillgoods")
public class SeckillGoodsController {

    @Autowired
    private SeckillGoodsService seckillGoodsService;

    /**
     * 根据时间菜单, 查询对应的秒杀商品列表数据返回
     * @param time  页面传入的秒杀时间菜单
     * @return
     */
    @GetMapping("/list")
    public List<SeckillGoods> list(@RequestParam("time") String time) {
        List<SeckillGoods> seckillGoodsList = seckillGoodsService.findSeckillGoodsListFromRedis(time);
        return seckillGoodsList;
    }
}
