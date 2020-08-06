package com.itheima.polymorphism06;

/**
 * 定义鼠标类: 满足USB接口,实现接口,重写抽象方法
 */
public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("鼠标开启");
    }

    @Override
    public void close() {
        System.out.println("鼠标关闭");
    }
}
