package com.itheima.abstract01;

/**
 *  抽象: 讲不清楚,抽象概念
 *  动物吃什么
 *
 *  抽象类的使用方式:
 *   1. 抽象类不能实例化对象,不能new
 *   2. 需要定义子类继承抽象类
 *   3. 子类必须重写抽象方法
 *      去掉abstract修饰,添加方法主体{}
 *   4. 创建子类的对象
 */
public class AbstractDemo {
    public static void main(String[] args) {
        //创建Cat对象,是Animal的子类的对象
        Cat cat = new Cat();
        cat.eat();

        //创建Dog对象,是Animal的子类的对象
        Dog dog = new Dog();
        dog.eat();
    }
}
