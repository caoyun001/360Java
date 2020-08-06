package com.changgou.seckill.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient(name = "seckill")
public interface SeckillOrderFeign {


    /**
     * 秒杀下单
     * @param time  秒杀商品时间菜单
     * @param id    下单商品的主键id
     * @return
     */
    @GetMapping("/seckillorder/add")
    public Boolean add(@RequestParam("time") String time, @RequestParam("id") String id);
}
