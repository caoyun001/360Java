package com.itheima.extends05;

/**
 * 新手机类:
 *   继续使用原有手机的功能,同时扩展出自己的新功能
 *
 *   继承老手机类,重写方法receive
 */
public class NewPhone extends OldPhone{
    /**
     * 重写父类的来电显示方法
     * 新手机也定义响铃,号码显示和姓名显示 ,没有必要
     * 因为父类的功能已经实现, 直接使用父类功能
     * 子类中调父类的方法receive()
     */
    public void receive(){
        //调用父类的方法,实现了号码, 姓名
        super.receive();
        System.out.println("推销");
        System.out.println("归属地");
    }
}
