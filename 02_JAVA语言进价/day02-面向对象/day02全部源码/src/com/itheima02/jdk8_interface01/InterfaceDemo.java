package com.itheima.jdk8_interface01;

/**
 *  JDK8 (1.8)对接口进行改进
 *  1: 接口中增加了方法体,默认方法,关键字 default
 *    实现类实现接口,用实现类的对象调用!!
 *    实现类可以重写接口的默认方法,如果重写了,执行实现类的重写
 *
 *  2: 增加静态方法修饰
 *    接口中可以使用static 修饰方法
 *    使用接口名.方法名() 直接调用
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        //创建接口实现类的对象
        MyInterfaceImpl my = new MyInterfaceImpl();
        my.show();

        //调用接口中的静态方法
        MyInterface.function();
    }

}
