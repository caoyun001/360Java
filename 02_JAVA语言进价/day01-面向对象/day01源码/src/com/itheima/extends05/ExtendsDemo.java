package com.itheima.extends05;

/**
 * 继承和方法重写思想,实现手机案例
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        //创建 老手机类
        OldPhone oldPhone = new OldPhone();
        oldPhone.call();
        oldPhone.sendMessage();
        oldPhone.receive();

        System.out.println("---------");
        //创建新的手机类
        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.sendMessage();

        newPhone.receive();
    }
}
