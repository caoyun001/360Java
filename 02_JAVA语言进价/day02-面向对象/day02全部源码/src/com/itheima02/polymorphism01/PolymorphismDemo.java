package com.itheima.polymorphism01;

import java.util.ArrayList;
import java.util.List;

/**
 * 多态的概念:
 *   多态生活中,一个事物具备的多种形态
 *      人: 张三  8岁上学(学生)  28岁工作(打工) 38岁作为父亲(有孩子) 58岁创业(老板)
 *      蚊子:  卵  幼虫(孑孓)  蛹  成虫(吸血)  全变态昆虫
 *
 *   程序中的多态,对象的多态性
 *   前提:
 *     1: 要有继承或者是接口实现
 *     2: 要有方法的重写
 *     3: 建立对象
 *       父类或者接口 变量 = new 子类或者实现类对象();
 *       特点: 执行子类的方法重写
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        //实现子类和父类的多态程序
        Person person = new Student();
        //对象person调方法eat()
        person.eat();

        //实现子类和父类的多态程序,父类是抽象类
        Animal animal = new Cat();
        animal.eat();

        //实现接口和实现类的多态程序
        MyInterface my = new MyInterfaceImpl();
        my.inter();
    }
}
