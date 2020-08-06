package com.itheima.buffered;

import java.io.*;

/**
 *  IO流对象,需要考虑就是效率
 *  读写单个字节方式,效率低
 *  字节数组缓冲方式,效率高
 *  JDK考虑高效,提供缓冲流,提高原有流对象的效率
 *
 *  字节输出流的缓冲流
 *    java.io.BufferedOutputStream 继承OutputStream
 *    缓冲流对象,必须依赖原始流(FileOutputStream)
 *    构造方法:
 *      BufferedOutputStream( OutputStream out) 传递任意的字节输出流
 *      能传递只有 FileOutputStream
 *    方法: write(字节,字节数组,数组部分)
 *
 *
 *   字节输入流的缓冲流
 *     java.io.BufferedInputStream继承InputStream
 *     构造方法:
 *       BufferedInputStream(InputStream in) 传递任意的字节输入流
 *       能传递只有 FileInputStream
 *    方法 : read() 读取字节,读取字节数组
 */
public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException{
        //利用缓冲流文件复制

        //创建字节输入流的缓冲流,构造方法,传递字节输入流对象
        //FileInputStream fis = new FileInputStream("e://a.avi");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e://a.avi"));

        //创建字节输出流的缓冲流,构造方法,传递字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e://copy/a.avi"));

        //缓冲流读写字节数组
        byte[] bytes = new byte[1024];
        int len = 0 ;
        while ( (len = bis.read(bytes))!=-1 ){
            bos.write(bytes,0,len);
        }

        bos.close();
        bis.close();
    }
}












