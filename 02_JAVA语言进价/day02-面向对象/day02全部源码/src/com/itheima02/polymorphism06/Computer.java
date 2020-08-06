package com.itheima.polymorphism06;

import java.util.ArrayList;

/**
 * 创建笔记本类:
 *   开机,关机,使用USB外接设备功能
 */
public class Computer {
    /**
     * 定义方法,实现使用外接设备功能
     * 外接设备,就是连接在USB接口上的设备
     *
     * 返回值: 调用方法后的结果的类型
     * 参数: 方法运行中的所需要的未知数据
     *
     * 但是哪个设备,不知道,方法的参数就应该是外接设备
     * 设备都会满足USB的接口规则,方法的参数可以是USB接口
     * 调用方法,传递参数,创建什么参数, 接口没有对象,实现类对象
     */
    public void useUSB( USB usb ){
        //usb接口引用,调用方法
        usb.open();
        usb.close();
    }


    public void powerOn(){
        System.out.println("开机");
    }

    public void powerOff(){
        System.out.println("关机");
    }
}
