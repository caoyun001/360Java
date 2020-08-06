package com.itheima.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符输出流 java.io.OutputStreamWriter 继承Writer类
 * Writer类: 具备写入数据的方法 write
 * write(int c)写入单个字符
 * write(char[] c)写入字符数组
 * write(char[] c,int off,int len)写入字节数组一部分,开始索引,写入的个数
 * write(String str) 写入字符串
 *
 * OutputStreamWriter类称为转换流: 字符流通向字节流的桥梁
 * 字符转成字节
 *
 * 转换: 字符,查询编码表,得到字节,交给字节流处理
 *
 * 注意: 字符流写入数据: 数据写入到内存中,而不是目的文件
 * 字符输出流父类 Writer,提供方法 flush()刷新,数据从内存中刷新到目的文件
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        writeGBK();
    }
    /**
     * 使用转换流OutputStreamWriter,将汉字写入文本文件
     * 采用编码表是GBK
     * 构造方法:
     * OutputStreamWriter(OutputStream out,String 编码表名字) 传递字节输出流
     *                  new FileOutputStream
     */
    public static void writeGBK()throws IOException{
        //创建字节输出流
        FileOutputStream fos = new FileOutputStream("e://gbk.txt");
        //创建转换流对象,构造方法传递字节输出流,传递字符串编码表名
        OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
        osw.write("你好");
        osw.close();
    }

    /**
     * 使用转换流OutputStreamWriter,将汉字写入文本文件
     * 采用编码表是UTF-8
     * 构造方法:
     * OutputStreamWriter(OutputStream out) 传递字节输出流
     *                  new FileOutputStream
     */
    public static void writeUTF()throws IOException{
        //创建字节输出流
        FileOutputStream fos = new FileOutputStream("e://utf.txt");
        //创建转换流对象,构造方法中,传递字节输出流
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        //转换流方法write写入数据
        osw.write("你好");
//        osw.flush();
        osw.close();//关闭流,刷新
    }
}
