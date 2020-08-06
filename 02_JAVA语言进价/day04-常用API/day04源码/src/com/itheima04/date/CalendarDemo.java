package com.itheima.date;

import java.util.Calendar;

/**
 * 日历类:
 *  java.util.Calendar 表示日历对象
 *  日历类是抽象类,不能创建对象
 *  找子类GregorianCalendar
 *
 *  日历字段概念: 日历中包含的内容就是日历字段
 *  年,月,日 时,分...  字段在程序中都是int类型
 *
 *  日历类的使用方法: 创建对象,调用方法
 *  但是:
 *    创建日历考虑问题, 国家,市区,语言
 *    我们自己创建日历对象非常复杂
 *    JDK帮你创建日历对象,充分考虑国家,市区,语言
 *    直接获取即可
 *
 *   Calendar是抽象类,但是抽象类中定义静态方法,直接类名调用了
 *   static Calendar getInstance(),方法的返回值是日历类的子类对象
 *   方法的返回值是父类类型
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();//帮你创建了子类对象
        System.out.println(cal);//java.util.GregorianCalendar
    }
}
