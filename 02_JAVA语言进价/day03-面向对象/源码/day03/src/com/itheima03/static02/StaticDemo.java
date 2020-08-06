package com.itheima.static02;

/**
 * 静态调用: 类名.静态成员
 *
 * System.out.println()
 * System是类
 * out是静态修饰
 *
 * main方法被JVM调用
 *
 * java HelloWorld.main  (类的名字)
 */
public class StaticDemo {
    public static void main(String[] args) {
        //静态方法,使用类名.调用
        //在同一个类中,类名和省略不写
        int sum = getSum(1,2);
        System.out.println(sum);

        //调用外类的静态方法,必须写类名
        Sum.divide(1,2);
    }

    /**
     * 定义方法,计算两个整数的和
     */
    public static int getSum(int a,int b){
        return a + b;
    }
}
