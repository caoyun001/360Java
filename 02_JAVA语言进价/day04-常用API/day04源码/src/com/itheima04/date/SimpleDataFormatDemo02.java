package com.itheima.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  如果以字符串的形式提供日期
 *  数据来源都是字符串, "2019-9-9"
 *  字符串转成日期对象
 *  实现步骤:
 *     1: 创建子类对象SimpleDateFormat
 *         在子类构造方法中,传递格式化后的日期格式
 *         日前格式参考API,不要胡来
 *          y 表示年, M表示月 , d月份中天数,  H表示0-23, m分钟,s秒
 *     2: 对象调用方法 Date parse(String str)
 *        传递字符串形式的时期,转成Date对象
 */
public class SimpleDataFormatDemo02 {
    public static void main(String[] args) throws ParseException {
        //定义日期格式的字符串
        String str = "2019-9-10";
        //创建子类对象
        //日期格式注意: 必须和要转的字符串的格式一致,否则转不了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //对象调用方法parse,传递字符串,返回日期对象
        Date date = sdf.parse(str);//方法有异常
        System.out.println(date);
    }
}
