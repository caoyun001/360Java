package com.itheima.polymorphism06;

/**
 * 创建USB接口,就是标准,规则
 * 任何的外接设备 ,必须实现接口,实现我的规则
 */
public interface USB {
    //抽象方法,开启方法
    public abstract void open();

    //抽象方法,关闭方法
    public abstract void close();
}
