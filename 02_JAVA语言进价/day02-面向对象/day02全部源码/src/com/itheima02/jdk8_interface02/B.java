package com.itheima.jdk8_interface02;

public interface B {
    public default void show(){
        System.out.println("接口B的默认方法show");
    }
}
