package com.itheima.final01;

import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.Scanner;

/**
 * 修饰符: 最终,不可改变,使用修饰符final
 * final:
 *   修饰类: 最终类,没有子类,不能被其他的类继承
 *     有的类的功能,已经非常完美了,不需要子类进行扩展
 *     学习过最终类:
 *        String,Scanner,System
 *
 *
 *   修饰方法: 最终方法,不能被子类重写
 *     父类的某些方法已经非常完美,不需要子类扩展
 *     补充: 无论方法上是否有final修饰符,调用没有区别
 *
 *   修饰局部变量: 一次赋值终身不变
 *     方法中定义的变量,加上修饰符final,变量值固定
 *     只能赋值一次
 *     final修饰符固定的是变量保存的地址!!
 *
 *   修饰成员变量: 一次赋值终身不变
 */
public class FinalDemo {
    public static void main(String[] args) {
        final int a =1;
        System.out.println(a);
        //变量是引用数据类型,final修饰符固定的是变量保存的地址!!
        //和数组中的元素无关
        final int[] arr = {1,2,3};
        arr[0] = 5;
        System.out.println(arr[0]);

        //变量person保存对象的地址,地址不能改变
        final Person person = new Person();
        person.name = "张三";
    }
}
