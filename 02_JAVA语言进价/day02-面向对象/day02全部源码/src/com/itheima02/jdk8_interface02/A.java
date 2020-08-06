package com.itheima.jdk8_interface02;

public interface A {
    public default void show(){
        System.out.println("接口A的默认方法show");
    }
}
