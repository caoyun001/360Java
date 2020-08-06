package com.itheima.interface04;

/**
 * C类同时实现A,B两个接口
 */
public class C implements A,B{
    public void a(){
        System.out.println("重写a方法");
    }

    public void b(){
        System.out.println("重写b方法");
    }
}
