package com.itheima.date;

import java.util.Calendar;

/**
 * 日历类Calendar的方法
 * get set add
 */
public class CalendarDemo02 {
    public static void main(String[] args) {
        method_3();
    }
    /**
     * 日历类Calendar的方法add
     * 日历的偏移量
     * 今天向后188天
     * 参数是负数,向前偏移
     * add(int field,int value)要偏移字段,偏移的实际数据
     */
    public static void method_3(){
        //静态方法,获取子类对象
        Calendar cal = Calendar.getInstance();
        //日历向后偏移188天
        cal.add(Calendar.DAY_OF_MONTH,188);
        System.out.println(cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日");
    }

    /**
     * 日历类Calendar的方法set
     * 日历在默认的情况下跟随操作系统日历
     * 通过set方法,对日历进行设置
     * set(int field,int value)设置日历中的某个字段,实际参数
     * set(int year,int month,int day)设置日历,年月日
     */
    public static void method_2(){
        //静态方法,获取子类对象
        Calendar cal = Calendar.getInstance();
        //日历设置为2019年的12月
        //cal.set(Calendar.MONTH,11);
        //设置日历2020年的3月5日
        cal.set(2020,2,5);
        System.out.println(cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日");
    }

    /**
     * 日历类Calendar的方法get
     * get()作用获取日历字段的值
     * get(年) 返回2019
     * int get(int field)
     * 日历字段的写法,看API
     */
    public static void method(){
        //静态方法,获取子类对象
        Calendar cal = Calendar.getInstance();
        //cal对象的方法get()获取年份
       /* int year = cal.get(Calendar.YEAR);
        System.out.println(year);*/
        System.out.println(cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日");
    }
}
