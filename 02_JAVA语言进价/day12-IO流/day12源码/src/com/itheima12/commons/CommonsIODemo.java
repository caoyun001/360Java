package com.itheima.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  IO流,read,write , 使用数组高效,缓冲流实现高效
 *
 *  第三方软件公司
 *  第一: Java版权Oracle
 *  第二: 我们自己
 *  第三: 除了第一,第二
 *
 *  第三方软件公司: 美国 apache 阿帕奇 软件基金会,出品软件, 免费,开源
 *  commons-IO 简化IO的工具类
 *  Apache web服务器 Tomcat
 *
 *
 *  org.apache.commons.io.IOUtils 处理IO中的功能
 *    IOUtils.copy(字节输入流,字节输出流)文件复制
 *    IOUtils.closeQuietly(任意流);释放资源,悄悄的关闭,
 *      流对象close()抛异常,悄悄关闭,处理异常
 *
 *   org.apache.commons.io.FileUtils
 *     FileUtils.writeStringToFile(File file, String data);字符串写入文件
 *     FileUtils.readFileToString(File file)读取文本字符串,返回String
 *     FileUtils.copyDirectoryToDirectory(File src,File dect);将一个目录复制到另一个目录
 *
 */
public class CommonsIODemo {
    public static void main(String[] args)throws IOException {
       // IOUtils.copy(new FileInputStream("e:/1.avi"),new FileOutputStream("e:/copy/1.avi"));

       // FileUtils.writeStringToFile(new File("day12/1.txt"),"你想写什么,就写什么OK?");

        //String string = FileUtils.readFileToString(new File("day12/1.txt"));
       // System.out.println(string);

        FileUtils.copyDirectoryToDirectory(new File("c:/java"),new File("e:/copy"));
    }
}
