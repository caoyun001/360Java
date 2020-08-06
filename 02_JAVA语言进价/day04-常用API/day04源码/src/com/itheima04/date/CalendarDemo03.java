package com.itheima.date;

import java.util.Calendar;

/**
 * 要求:
 *   指定一个年份,计算出是不是闰年
 *   闰年2月份是29天, 平年是28天
 *  实现思想:
 *    日历对象实现功能
 *    将日历设置到这一年的3月1日
 *    日历向前推一天
 */
public class CalendarDemo03 {
    public static void main(String[] args) {
        int year = 2004;//指定的年份
        Calendar cal = Calendar.getInstance();
        //设置日历到这年的3月1日
        cal.set(year,2,1);
        //日历向前推一天
        cal.add(Calendar.DAY_OF_MONTH,-1);
        //获取这个天数
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
    }
}
