package com.changgou.seckill.controller;

import com.changgou.seckill.config.TokenDecode;
import com.changgou.seckill.pojo.SeckillOrder;
import com.changgou.seckill.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/seckillorder")
public class SeckillOrderController {

    @Autowired
    private TokenDecode tokenDecode;

    @Autowired
    private SeckillOrderService seckillOrderService;

    /**
     * 秒杀下单
     * @param time  秒杀商品时间菜单
     * @param id    下单商品的主键id
     * @return
     */
    @GetMapping("/add")
    public Boolean add(@RequestParam("time") String time, @RequestParam("id") String id) {
        //1. 获取当前登录用户的用户名
        Map<String, String> userInfo = tokenDecode.getUserInfo();
        String username = userInfo.get("username");
        //2. 调用service下单
        boolean flag = seckillOrderService.add(id, time, username);
        return flag;
    }
}
