package com.itheima;

import com.itheima.pojo.GoodsOne;
import com.itheima.pojo.GoodsThree;
import com.itheima.pojo.GoodsTwo;

/**
 * @author: hero brother
 * @date: Created in 2019/11/21
 * @description:
 * @version: 1.0
 */
public class LombokDemo2 {
    public static void main(String[] args) {
        //通构造函数创建对象
        GoodsOne good = new GoodsOne();
        good.setId(1l);
        good.setTitle("小米手机");
        good.setCategory("手机");
        good.setBrand("小米");
        good.setPrice(19999.0);
        good.setImages("http://image.leyou.com/12479122.jpg");
        System.out.println(good);

        //SqlSessionFactory，
        //SqlSessionFactoryBuilder,把复杂的创建对象的过程，封装在一个对象中(builder，构建者对象)

        //new GoodsTwo("","",""....)
        //beanFactory
        //构建者设计模式，SqlSessionFactoryBuilder ，SqlSessionFactory
        //TODO 构建者创建对象-不使用Lombok
        /**
         * 所有的框架，所有技术：永恒不变的追求：write less do more！
         */
        GoodsThree goodsThree = GoodsThree.builder().id(1L).title("小米手机").category("手机").price(1999.0).build();
        //TODO 构建者创建对象-使用lombok
        GoodsTwo goodsTwo = GoodsTwo.builder().id(1L).title("小米手机").build();
    }
}
