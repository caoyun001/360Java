package com.itheima.file04;

import java.io.File;

/**
 *  File类的创建功能
 *    操作系统中,或者是磁盘
 *    文件,目录
 */
public class FileDemo {
    public static void main(String[] args)throws Exception{
        method();
    }
    /**
     * boolean delete()删除目录或者是文件
     * 删除成功返回true,删除File构造方法中封装路径
     *
     * 注意:
     *  1: 直接删除,机器上彻底删除(有风险)
     *  2: 删除是文件夹,保证文件夹是空的,否则不能删除
     */
    public static void method_3(){
        File file = new File("e:\\abc");
        boolean b = file.delete();
        System.out.println(b);
    }

    /**
     *  boolean mkdirs()创建文件夹,这个文件夹不存在
     *  如果存在,不创建.
     * 创建成功返回true.
     *
     * mkdirs() 可以同时创建多级目录
     * mkdir() 只能创建一级目录
     */
    public static void method_2(){
        File file = new File("e:\\A.txt");
        boolean b = file.mkdirs();
        System.out.println(b);
    }

    /**
     * boolean createNewFile() 创建新文件,这个文件不存在
     * 如果存在,不创建.
     * 创建成功返回true.
     * 创建文件的路径,写在File构造方法中
     *
     * 狗只能生狗
     */
    public static void method()throws Exception{
        File file = new File("e:\\a.txt");
        boolean b = file.createNewFile();
        System.out.println(b);
    }
}
