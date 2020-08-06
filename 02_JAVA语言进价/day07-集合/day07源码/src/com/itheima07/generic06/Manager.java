package com.itheima.generic06;

public class Manager extends Employee {
    public void work() {
        System.out.println("班主任处理班务:"+super.getName()+"::"+super.getAge());
    }
}
