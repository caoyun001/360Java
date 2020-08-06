package com.itheima.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流复制文件,任意文件
 * 不能是文件夹
 */
public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        copy_2();
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }
    /**
     * FileInputStream 读取字节,存储数组
     * FileOutputStream 写入字节数组
     */
    public static void copy_2()throws IOException{
        //输入流对象,绑定数据源
        FileInputStream fis = new FileInputStream("e:/a.avi");
        //输出流对象,绑定数据目的
        FileOutputStream fos = new FileOutputStream("e:/copy/a.avi");
        byte[] bytes = new byte[1024];
        int len = 0 ;
        while ((len = fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }


    /**
     * FileInputStream 读取单个字节
     * FileOutputStream 写入单个字节
     */
    public static void copy()throws IOException{
        //输入流对象,绑定数据源
        FileInputStream fis = new FileInputStream("e:/a.avi");
        //输出流对象,绑定数据目的
        FileOutputStream fos = new FileOutputStream("e:/copy/a.avi");
        int len = 0;
        while ((len = fis.read())!=-1){
            fos.write(len);
        }
        fos.close();
        fis.close();
    }
}
