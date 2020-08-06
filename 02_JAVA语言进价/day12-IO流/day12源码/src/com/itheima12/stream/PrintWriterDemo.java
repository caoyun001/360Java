package com.itheima.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  打印流:  负责输出,不负责输入
 *  java.io.PrintStream  字节流
 *  java.io.PrintWriter  字符流
 *  打印流特点:
 *    1: 方便打印各种数据 (println(数据原样输出))
 *    2: 只负责输出目的,不负责数据源
 *    3: 打印流永远不会抛出IOException
 *       但是,不抛出别的异常
 *    4: 可以启用自动刷新
 *
 *  java.io.PrintStream  字节流
 *    构造方法封装的就是数据目的
 *    File对象,String 文件名, OutputStream字节输出流
 *
 *  java.io.PrintWriter  字符流
 *    构造方法封装的就是数据目的
 *    File对象,String 文件名, OutputStream字节输出流,Writer字符输出流
 *
 *  打印流的方法,不需要讲解
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        method_2();
    }

    /**
     * 打印流输出数据,带自动刷新PrintWriter
     * 前提:
     *   1: 打印流的输出目的,必须是流对象
     *   2: 构造方法第二个参数, true
     *       File String  流对象new FileOutputStream(File可以是String)
     *   3: 方法只能调用println,print,format 三个中的一个
     */
    public static void  method_2()throws IOException{
        FileOutputStream fos = new FileOutputStream("day12/print.txt");

        //创建打印流对象,开启自动刷新
        PrintWriter pw = new PrintWriter(fos,true);

        pw.println(1);
        pw.println(1);
        pw.println(1);
        pw.println(1);
        pw.println(1);
        pw.println(1);
        pw.println(1);
        pw.println(1);
        pw.println(1);

        pw.close();
    }

    /**
     * 打印流输出数据,输出目的是字节输出流
     */
    public static void method()throws IOException{
        FileOutputStream fos = new FileOutputStream("day12/print.txt");
        //创建打印流对象,构造方法传递字节输出流
        PrintWriter pw = new PrintWriter(fos);
        //打印数据
        pw.println(100);
        pw.close();
    }
}
