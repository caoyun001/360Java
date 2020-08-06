package com.itheima.file;

import java.io.File;

/**
 * File对象
 *   文件,路径名,目录的抽象表示形式
 *   文件: 存储实际数据的容器  File
 *   目录: 文件夹  Directory
 *   路径: 文件或者是目录在磁盘中的存储位置  Path
 *
 *   java.io.File 文件,路径,目录 封装成对象
 *
 */
public class FileDemo {
    public static void main(String[] args) {
        //File静态成员变量 : static String pathSeparator  与系统有关的路径分隔符
        String str = File.pathSeparator;  //   ; 分号 Windows操作系统中,一个路径结束
        System.out.println(str);

        //静态成员变量: static String  separator 与系统有关的默认名称分隔符
        str = File.separator; //   \ 是一个目录和下一个目录的分割符号
        System.out.println(str);
    }
}
