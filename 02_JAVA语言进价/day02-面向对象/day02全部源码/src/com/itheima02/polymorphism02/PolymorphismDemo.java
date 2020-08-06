package com.itheima.polymorphism02;

/**
 * 多态程序的实现细节:
 *   1: 成员变量特点
 *     编译: 看父类中是否有这个变量,如果有编译成功,否则编译失败
 *     运行: 运行父类中的变量
 *
 *   2: 成员方法特点
 *     编译: 看父类中是否有这个方法,如果有编译成功,否则编译失败
 *     运行: 运行子类的方法重写
 *
 *   小结论:
 *      变量,编译运行都是父类
 *      方法,编译父类,运行子类
 *
 *      编译看左边,运行看右边,代码中的等于号
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        //多态形式创建对象
        Fu fu = new Zi();
        System.out.println(fu.s);
        fu.show();
    }
}
