package com.itheima.inner01;

/**
 * 内部类:
 *   class A{
 *       class B{}
 *   }
 *   B类是A的内部类,A是B的外部类
 *
 *   类概念: 是对生活中一类事物的抽象描述
 *   描述一个事物的时候,在这个事物的内部,存在着另一个具体的事物
 *
 *   汽车类
 *   class Car{
 *       品牌,价格,颜色...
 *
 *       发动机是一个独立事物
 *       class 发动机{}
 *
 *       public void ()
 *   }
 *   内部类: 能不能直接使用外部类的成员呢
 *   可以直接使用外部类的成员,包括私有修饰
 *
 *   外部类: 能不能直接使用内部类的成员呢,不能
 *   创建内部类的对象,才能使用内部类成员
 *
 *   内部类是外部类的成员, 和对象有关系
 *   公式:
 *     外部类名.内部类名  变量名 = new 外部类对象().new 内部类对象()
 *     变量名.内部类方法()
 *
 *
 */
public class InnerClassDemo {
    public static void main(String[] args) {
        //调用内部类的方法inner()
        //外部类名.内部类名  变量名 = new 外部类对象().new 内部类对象()
        Outer.Inner  in = new Outer().new Inner();
        in.inner();
    }
}
