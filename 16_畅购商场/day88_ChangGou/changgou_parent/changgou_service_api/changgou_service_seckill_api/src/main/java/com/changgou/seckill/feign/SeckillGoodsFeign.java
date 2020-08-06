package com.changgou.seckill.feign;

import com.changgou.seckill.pojo.SeckillGoods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 */
@FeignClient(name = "seckill")
public interface SeckillGoodsFeign {

    /**
     * 根据时间菜单, 查询对应的秒杀商品列表数据返回
     * @param time  页面传入的秒杀时间菜单
     * @return
     */
    @GetMapping("/seckillgoods/list")
    public List<SeckillGoods> list(@RequestParam("time") String time);
}
