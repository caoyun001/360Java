package com.itheima;

import com.itheima.pojo.GoodsOne;
import com.itheima.pojo.GoodsTwo;

/**
 * @author: hero brother
 * @date: Created in 2019/11/21
 * @description:
 * @version: 1.0
 */
public class LombokDemo1 {
    public static void main(String[] args) {
        GoodsOne good = new GoodsOne();
        good.setId(1l);
        good.setTitle("小米手机");
        good.setCategory("手机");
        good.setBrand("小米");
        good.setPrice(19999.0);
        good.setImages("http://image.leyou.com/12479122.jpg");
        System.out.println(good);

        GoodsTwo goodsTwo = new GoodsTwo();
        goodsTwo.setId(1L);
    }
}
