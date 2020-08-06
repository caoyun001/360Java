package com.itheima;

/**
 * 抽象类: 特点
 *  1. 抽象类也有构造方法
 *     构造方法是为了创建对象,抽象类不能new对象
 *
 *  2. 抽象类中可以定义成员变量吗
 *    可以,和以前的定义方式一致
 *
 *  3. 抽象类中是否可以不定义抽象方法
 *    可以,作为适配器使用
 */
public abstract class Animal {
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
