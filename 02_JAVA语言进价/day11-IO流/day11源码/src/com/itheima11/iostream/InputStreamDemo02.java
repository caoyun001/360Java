package com.itheima.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节输入流,读取数据
 * 利用字节数组进行存储
 * 输入流方法:
 *   int read(byte[] b)
 */
public class InputStreamDemo02 {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("e:/a.txt");
        //定义字节数组,推荐写1KB的整数倍
        byte[] bytes = new byte[1024];
        //定义遍历,接收int返回值
        int len = 0;
        /**
         * read(数组)存储读取到字节
         * int返回值,读取到的个数
         */
       while ( (len = fis.read(bytes))!=-1){
           System.out.print(new String(bytes,0,len));
       }


        fis.close();
    }
}

/**
 *
 len = fis.read(bytes);
 System.out.println(len);//2
 System.out.println(new String(bytes));//cd

 len = fis.read(bytes);
 System.out.println(len);//1
 System.out.println(new String(bytes));// ed


 len = fis.read(bytes);
 System.out.println(len);//-1
 System.out.println(new String(bytes));// ed
 */
