package com.itheima.system;

public class Person {
    protected void finalize() throws Throwable {
        System.out.println("对象被清理");
    }
}
