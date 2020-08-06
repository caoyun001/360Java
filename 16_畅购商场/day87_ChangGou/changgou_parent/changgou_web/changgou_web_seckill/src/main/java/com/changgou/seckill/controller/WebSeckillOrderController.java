package com.changgou.seckill.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.seckill.feign.SeckillOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  秒杀下单
 *
 *  由于页面都是ajax请求, 返回json数据, 所以这里类上使用@RestController注解
 */
@RestController
@RequestMapping("/wseckillorder")
public class WebSeckillOrderController {

    @Autowired
    private SeckillOrderFeign seckillOrderFeign;

    /**
     * 秒杀下单
     * @param time
     * @param id
     * @return
     */
    @GetMapping("/add")
    public Result add(String time, String id) {
        Boolean flag = seckillOrderFeign.add(time, id);
        if (flag) {
            return new Result(true, StatusCode.OK, "下单成功!");
        } else {
            return new Result(true, StatusCode.OK, "下单失败, 此商品已售罄");
        }
    }
}
