package com.itheima.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  日期格式化:
 *    Date对象直接输出日期,不方便国人理解
 *
 *   java.text.DateFormat 日期格式化
 *   是一个abstract修饰的抽象类,创建他的子类对象
 *   SimpleDateFormat对象
 *
 *   有子类对象 new SimpleDateFormat().方法()
 *   1: 子类重写
 *   2: 是父类的
 *
 *   要求: 日期格式化后的结果 2019年9月10日 10点20分10秒
 *   实现步骤:
 *     1: 创建子类对象SimpleDateFormat
 *         在子类构造方法中,传递格式化后的日期格式
 *         日前格式参考API,不要胡来
 *          y 表示年, M表示月 , d月份中天数,  H表示0-23, m分钟,s秒
 *     2: 对象调用方法 String format(Date date)
 *        传递日期对象Date, 返回格式化后的字符串
 *
 */
public class SimpleDataFormatDemo {
    public static void main(String[] args) {
        //创建子类对象,构造方法中,传递日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
        //对象调用方法format,父类继承
        String date = sdf.format(new Date());
        System.out.println(date);

        /*Date d = new Date();
        System.out.println(d);*/
    }
}
