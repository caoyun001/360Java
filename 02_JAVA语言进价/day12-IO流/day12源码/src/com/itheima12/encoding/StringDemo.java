package com.itheima.encoding;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *  String对象
 *    byte[] getBytes()字符串转成字节数组
 *      汉字->数组 编码过程
 *    new String(byte[] b)数组转成字符串
 *      数组->汉字 解码过程
 *
 *    无论编码(字符串转数组),还是解码(数组转成字符串),保证使用编码表一致行
 */
public class StringDemo {
    public static void main(String[] args)throws UnsupportedEncodingException  {
        method_2();
    }
    /**
     * String类构造方法,数组转成字符串
     * new String(byte[] b)
     * new String(byte[] b,String 编码表名)
     */
    public static void method_2() throws UnsupportedEncodingException {
        byte[] bytes = {-60, -29};
        String s = new String(bytes,"GBK");
        System.out.println(s);
    }

    /**
     * byte[] getBytes()字符串转成字节数组
     * byte[] getBytes(String 编码表名字)字符串转成字节数组
     * 使用平台的默认字符集将此 String 编码为 byte 序列
     * 平台(操作系统) GBK
     *
     * IDEA工具,启动JVM虚拟机,设置JVM启动参数 -Dfile.encoding=UTF-8
     */
    public static void method() throws UnsupportedEncodingException {
       byte[] bytes =  "你".getBytes("gbk"); //[-28, -67, -96]    [-60, -29]
        System.out.println(Arrays.toString(bytes));
    }
}
