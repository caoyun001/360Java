package com.itheima.stream;

import java.io.FileReader;
import java.io.IOException;

/**
 *  java.io.FileReader 读取字符文件的便捷类
 *  继承 InputStreamReader ,继承Reader
 *  FileReader读取文本文件,不能改变编码表的,使用默认的UTT-8
 *
 *  构造方法:
 *    FileReader(String 文件名)
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException{
        //创建字符输入流的便捷类对象
        FileReader fr = new FileReader("C:\\Java\\jdk1.8.0_221\\src\\java\\lang\\Object.java");
        char[] ch = new char[1024];
        int len = 0 ;
        while ( (len = fr.read(ch))!=-1){
            System.out.println(new String(ch,0,len));
        }
        fr.close();
    }
}
