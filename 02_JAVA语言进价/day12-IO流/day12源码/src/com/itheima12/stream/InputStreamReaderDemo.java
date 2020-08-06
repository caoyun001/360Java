package com.itheima.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  java.io.InputStreamReader 继承Reader 字符输入流
 *  InputStreamReader字符输入流,父类Reader定义好的读取的方法
 *
 *  int read()读取单个字符
 *  int read(char[] c)读取字符,存储在数组中
 *
 *  InputStreamReader是转换流, 字节流通向字符流的桥梁
 *  字节转成字符
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        readGBK();
    }
    /**
     * InputStreamReader转换流,读取文本文件
     * 使用编码表GBK
     * 构造方法:
     *    InputStreamReader(InputStream in,String 编码表名) 传递字节输入流
     *                  new FileInputStream
     */
    public static void readGBK()throws IOException{
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("e://gbk.txt");
        //创建转换流对象,构造方法传递字节输入流,指定使用编码表
        InputStreamReader isr = new InputStreamReader(fis,"GBK");
        char[] ch = new char[1024];
        int len = 0 ;
        while ( (len = isr.read(ch)) !=-1){
            //数组转成字符串打印
            System.out.println( new String(ch,0,len) );
        }

        isr.close();
    }

    /**
     * InputStreamReader转换流,读取文本文件
     * 使用编码表UTF-8
     * 构造方法:
     *   InputStreamReader(InputStream in) 传递字节输入流
     *                  new FileInputStream
     */
    public static void readUTF()throws IOException{
        //创建字节输入流
        FileInputStream fis = new FileInputStream("e:/utf.txt");
        //创建转换流对象,构造方法传递字节输入流
        InputStreamReader isr = new InputStreamReader(fis);
        char[] ch = new char[1024];
        int len = 0 ;
        while ( (len = isr.read(ch)) !=-1){
            //数组转成字符串打印
            System.out.println( new String(ch,0,len) );
        }

        isr.close();
    }
}
