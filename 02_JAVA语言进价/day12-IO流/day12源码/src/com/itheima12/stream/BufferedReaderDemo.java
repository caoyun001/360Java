package com.itheima.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  java.io.BufferedReader 字符输入流缓冲流
 *  继承 Reader,本身也是字符输入流 (只能操作文本文件)
 *  BufferedReader自己的功能: String readLine()读取文本一行
 *
 *  BufferedReader构造方法
 *    BufferedReader(Reader r)构造方法可以传递任意字符输入流
 *    能传递的字符输入流:
 *    FileReader  InputStreamReader
 *
 *
 *    readLine()读取文本行,返回字符串
 *    读取到文件的末尾返回 null
 *
 *     readLine()读取文本行,是否包含换行符 ?  ( \r \n) 没有,返回的都是有效字符
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException{
        //创建字符输入流
       // FileReader fr = new FileReader("e:/123.txt");
        //创建字符输入流的缓冲流,构造方法中,传递字符输入流
        BufferedReader bfr = new BufferedReader( new FileReader("e:/123.txt"));
        //缓冲流对象的方法 String readLine 读取文本一行
        String line = null;
        while ( (line = bfr.readLine()) != null){
            System.out.println(line);
        }
        bfr.close();
    }
}
/**
 *       String line = bfr.readLine();
 System.out.println(line);


 line = bfr.readLine();
 System.out.println(line);

 line = bfr.readLine();
 System.out.println(line);

 line = bfr.readLine();
 System.out.println(line);
 */