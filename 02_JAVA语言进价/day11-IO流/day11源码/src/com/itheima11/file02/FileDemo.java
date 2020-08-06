package com.itheima.file02;

import java.io.File;

/**
 * File类构造方法
 */
public class FileDemo {
    public static void main(String[] args) {
        method_3();
    }
    /**
     * File类构造方法
     *   File(File parent,String child)传递File类型的父路径,和字符串的子路径
     *   第一个参数是File对象
     */
    public static void method_3(){
        File parent = new File("E:\\讲义\\JavaEE16天讲义");
        File file = new File(parent,"day11-IO流");
        System.out.println(file);
    }

    /**
     * File类构造方法
     *  File(String parent,String child)传递字符串的父路径,和字符串的子路径
     *  程序中,分的越开越好
     *  单独操作父路径,单独操作子路径
     */
    public static void method_2(){
        File file = new File("E:\\讲义\\JavaEE16天讲义","day11-IO流");
        System.out.println(file);
    }

    /**
     * File类构造方法
     *   File(String path)传递字符串的路径
     */
    public static void method(){
        File file = new File("E:\\讲义\\JavaEE16天讲义\\day11-流");
        System.out.println(file);
    }
}
