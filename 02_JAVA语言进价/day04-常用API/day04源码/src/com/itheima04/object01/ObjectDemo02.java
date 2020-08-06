package com.itheima.object01;

import java.util.ArrayList;

/**
 *  Object类定义方法 toString()
 *  返回值是String类型字符串
 *  含义: 返回该对象的字符串表示形式
 *
 *  Person类继承Object,肯定拥有方法toString()
 *
 *  结论:
 *    toString()方法返回的字符串,包名类名@对象内存地址
 *    输出语句中System.out.println(对象) 默认调用对象的方法toString()
 *
 *    地址和我们开发没有什么关系
 *    重写父类的toString()方法
 *    目的返回成员变量的值!!
 *
 */
public class ObjectDemo02 {
    public static void main(String[] args) {
        Person person = new Person("张三",20);
        //person对象调用方法toString()
        String str =  person.toString();//com.itheima.object01.Person@1b6d3586
        System.out.println(str);
        System.out.println(person);//com.itheima.object01.Person@1b6d3586  默认调用toString()
    }
}
