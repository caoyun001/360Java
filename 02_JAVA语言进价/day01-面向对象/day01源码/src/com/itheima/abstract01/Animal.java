package com.itheima.abstract01;

/**
 * 动物类: 定义吃饭的方法
 * 吃饭方法,不能明确吃的是什么,不需要再方法体中写内容
 * {}不写,直接分号结束
 *
 * 没有方法体的方法,成为抽象方法
 * 关键字修饰,抽象 abstract
 *
 * 抽象方法必须存在于抽象的类中,对类也进行抽象修饰
 */
public abstract class Animal {
    public  abstract void eat();
}
