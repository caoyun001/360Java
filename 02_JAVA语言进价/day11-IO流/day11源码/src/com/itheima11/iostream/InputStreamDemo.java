package com.itheima.iostream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *  java.io.InputStream字节输入流
 *  从设备中读取数据,所有字节输入流的父类 read
 *  读取数据的方法
 *    int read() 读取单个字节
 *    int read(byte[] b)读取字节,存储在数组中
 *
 *  子类 FileInputStream
 *  构造方法:
 *    FileInputStream(File file)   传递File对象
 *    FileInputStream(String name) 传递String对象
 *    在输入流的构造方法中,传递的称为数据源
 */
public class InputStreamDemo {
    /**
     *  字节输入流FileInputStream读取文件
     *  read()读取1个字节,返回int类型
     *  返回值: int类型,读取到字节,转成int类型
     *  读取到流的末尾,返回-1
     */
    public static void main(String[] args) throws IOException{
        //创建字节输入流对象,构造方法中,传递数据源(存在的)
        FileInputStream fis = new FileInputStream("e:/a.txt");
        //read()方法读取单个字节
        //while循环读取,循环什么时候结束 read()返回-1
        int len = 0 ;//接收read()返回值
        while (  (len = fis.read()) != -1 ){
            System.out.print( (char)len );
        }
        fis.close();
    }
}
/**
 *
 len = fis.read();
 System.out.println(len);

 len = fis.read();
 System.out.println(len);

 len = fis.read();
 System.out.println(len);

 len = fis.read();
 System.out.println(len);
 */
