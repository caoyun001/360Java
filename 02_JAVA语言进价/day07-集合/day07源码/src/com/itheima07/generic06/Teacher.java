package com.itheima.generic06;

public class Teacher extends Employee {
    public void work(){
        System.out.println("老师上课"+ super.getName()+"::"+super.getAge());
    }
}
