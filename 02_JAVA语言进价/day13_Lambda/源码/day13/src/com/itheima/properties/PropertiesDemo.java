package com.itheima.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  Properties是Map集合,键值对
 *  可以和IO结合,数据的持久化
 *  集合关键的方法 load(输入流)  字节可以,字符可以
 *  会从流中读取键值对的数据
 *
 *  IO流读取文件,存储的键值对数据,存储在Properties集合
 */
public class PropertiesDemo {
    public static void main(String[] args)throws IOException {
        Properties properties =new Properties();
        FileInputStream fis = new FileInputStream("day13/config.properties");
        properties.load(fis);
        fis.close();
        System.out.println(properties);
    }
}
