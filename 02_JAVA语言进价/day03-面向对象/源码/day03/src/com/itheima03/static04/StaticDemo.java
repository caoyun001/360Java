package com.itheima.static04;

/**
 *  三种代码块  {  代码块 }, 其中两种没有使用价值
 *  1: 局部代码块  方法中
 *  2: 构造代码块  写在类中,创建对象的时候运行了
 *  3: 静态代码块  写在类中, static{}
 *     在使用类的成员的时候,执行,仅仅一次
 *     只要你用这个类了,静态代码块就会执行,无论建立对象,调用方法,调用变量
 *     JDBC:  JVM加载数据库驱动程序
 */
public class StaticDemo {
    public static void main(String[] args) {
        new Student();
        new Student();
    }
}
