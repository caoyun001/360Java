package com.itheima.file05;

import java.io.File;

/**
 * File类判断方法
 * 方法的返回值boolean
 */
public class FileDemo {
    public static void main(String[] args) {
        method_2();
    }
    /**
     * boolean isDirectory()判断File构造方法中路径,是不是文件夹
     * 是文件夹,返回true
     *
     * boolean isFile()判断File构造方法中路径,是不是文件
     * 是文件,返回true
     */
    public static void method_2(){
        File file = new File("C:\\Java\\jdk1.8.0_221\\src.zip");
        boolean b = file.isDirectory();
        System.out.println(b);
    }

    /**
     *  boolean exists()判断File构造方法中,封装的路径
     *  是否存在,存在返回true
     */
    public static void method(){
        File file = new File("C:\\Java\\jdk1.8.0_221\\src.zipp");
        boolean b = file.exists();
        System.out.println(b);
    }
}
