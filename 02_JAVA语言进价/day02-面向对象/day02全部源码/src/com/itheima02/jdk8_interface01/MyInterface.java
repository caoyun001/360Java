package com.itheima.jdk8_interface01;

public interface MyInterface {
    /**
     * JDK8版本,可以定义静态修饰的方法
     */
    public static void function(){
        System.out.println("接口的静态方法");
    }

    /**
     * JDK8版本,可以定义默认方法
     */
    public default void show(){
        System.out.println("这里是接口的默认方法");
    }
}
