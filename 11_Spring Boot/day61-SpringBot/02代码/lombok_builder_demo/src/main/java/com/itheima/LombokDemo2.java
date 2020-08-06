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
        //创建对象的几种方式：
        //1、构造函数new GoodsTwo("","",""....)
        //2、对象工厂beanFactory
        //3、反射
        //4、构建者用来创建对象的一种方式：SqlSessionFactoryBuilder ==> SqlSessionFactory
        //TODO 构建者创建对象-不使用Lombok
        GoodsThree goodsThree = GoodsThree.builder().id(1L).title("小米手机").category("手机").build();
        //TODO 构建者创建对象-使用lombok
        GoodsTwo goodsTwo = GoodsTwo.builder().id(2L).build();
    }
}
