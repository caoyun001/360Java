package com.itheima.extends05;

/**
 * 老手机类:
 *  三个方法: 打电话,来电,发送信息
 */
public class OldPhone {
    //打电话 功能
    public void call(){
        System.out.println("拨号,打电话");
    }
    //来电
    public void receive(){
        System.out.println("响铃");
        System.out.println("显示姓名");
        System.out.println("显示电话号码");
    }

    //发送信息
    public void sendMessage(){
        System.out.println("发送短信");
    }
}
