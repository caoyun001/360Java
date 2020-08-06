package com.itheima.polymorphism06;

/**
 *  键盘类,实现接口USB
 */
public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("键盘开启");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭");
    }
}
