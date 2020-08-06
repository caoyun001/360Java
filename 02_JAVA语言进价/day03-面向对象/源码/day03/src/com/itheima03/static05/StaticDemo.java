package com.itheima.static05;

/**
 *  子类和父类的多态程序 (对象的多态性)
 *  静态在内存中,优先于对象, 静态和对象无关!!
 *
 *    静态成员变量: 编译还是运行,看父类中的成员变量
 *
 *  多态: 只有非静态的方法,编译是父类,运行时子类
 *
 *  深入: javac编译器,检测代码语法  fu.show();
 *  知道方法是静态的,编译的时候,直接将fu对象,改写为类名.show();
 */
public class StaticDemo {
    public static void main(String[] args) {
        Fu fu = new Zi();
     //   System.out.println(fu.s);

        Fu.show();
    }
}
