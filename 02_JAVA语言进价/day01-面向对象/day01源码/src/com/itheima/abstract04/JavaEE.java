package com.itheima.abstract04;

/**
 * JavaEE工程师,但是属于员工一种,继承员工类
 */
public class JavaEE extends Employee{
    public void work(){
        //输出JavaEE工程师的工号和姓名
        System.out.println("JavaEE工程师开发天猫"+super.getId()+"::"+super.getName());
    }
}
