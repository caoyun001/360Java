package com.itheima.static03;

/**
 * 静态调用
 *  不能在静态的方法中,引用非静态的变量
 *
 *  非静态变量,跟随对象在堆内存  (后人)
 *
 *  静态成员变量,跟随类在方法区  (先人)
 *
 *  静态方法中不能写this和super
 */
public class StaticDemo {
    public static void main(String[] args) {
        Student.eat();
    }
}
