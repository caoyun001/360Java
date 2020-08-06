package com.itheima.date;

import java.util.Date;

/**
 *  生活有日期,计算机也有日期
 *  面向对象语言,一切都是对象,日期也是对象
 *  java.util.Date 日期对象
 *
 *  小结: Date表示日期对象
 *  Date主要作用提供了日期对象和毫秒值直接的转换
 *  日期不能进行数学计算,但是毫秒值可以
 *
 *  日期转成毫秒值:
 *      Date对象方法getTime()   new Date().getTime()
 *
 *   毫秒值转成日期:
 *     Date对象构造方法  new Date(毫秒值)
 *     new Date().setTime(毫秒值)
 */
public class DateDemo {
    public static void main(String[] args) {
        method_4();
    }
    /**
     * Date类的方法
     * void setTime(long time)传递毫秒值
     * 日期设定在毫秒值上
     */
    public static void  method_4(){
        Date date = new Date();
        date.setTime(1568081327343L);
        System.out.println(date);
    }

    /**
     * Date类的方法
     * long getTime() 返回当前日期的毫秒值
     */
    public static void method_3(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }

    /**
     * Date类的构造方法
     * 有一个long参数的构造
     * 参数是毫秒值的意思  1000毫秒 = 1秒
     * Java语言设置时间原点,称为0毫秒
     * 1970-1-1 0:0:0
     *
     * 传递毫秒值的构造方法意义: 将日期设定到毫秒值上
     */
    public static void method_2(){
        //构造方法传递毫秒值 ?
        Date date = new Date(1552909879931L);
        System.out.println(date);
    }

    /**
     * Date类的构造方法
     * 无参数构造
     * 创建日期对象,跟随操作系统
     */
    public static void method(){
        Date date = new Date();
        System.out.println(date);// Tue Sep 10 09:57:55 CST 2019
    }
}
