package com.itheima.encoding;

/**
 *  char类型,存储汉字,使用的哪个编码表
 *  String类型
 *
 *  char内存中占几个字节: 2个字节  UTF-16 (定长,无论是什么,全部2个字节)
 *
 */
public class CharDemo {
    public static void main(String[] args) {
        char ch = '\uAE18';
        String s = "我";
        System.out.println(ch);
        System.out.println(s);
    }
}
