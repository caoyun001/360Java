package com.changgou.seckill.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.seckill.feign.SeckillGoodsFeign;
import com.changgou.seckill.pojo.SeckillGoods;
import com.changgou.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("wseckillgoods")
public class WebSeckillGoodsController {

    @Autowired
    private SeckillGoodsFeign seckillGoodsFeign;

    /**
     * 跳转到秒杀首页
     * @return
     */
    @GetMapping("/toIndex")
    public String toIndex() {
        return "seckill-index";
    }

    /**
     * 首页加载秒杀时间菜单数据
     */
    @GetMapping("/timeMenus")
    @ResponseBody
    public List<String> timeMenus() {
        List<Date> dateMenus = DateUtil.getDateMenus();
        List<String> dateList = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Date dateMenu : dateMenus) {
            dateList.add(simpleDateFormat.format(dateMenu));
        }
        return dateList;
    }

    /**
     * 根据时间菜单, 查询对应的秒杀商品列表数据返回
     * @param time  页面传入的秒杀时间菜单
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public Result<List<SeckillGoods>> list(@RequestParam("time") String time) {
        List<SeckillGoods> list = seckillGoodsFeign.list(time);
        return new Result<>(true, StatusCode.OK, "查询成功", list);
    }
}
