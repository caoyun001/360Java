package com.itheima.file06;

import java.io.File;

/**
 * File类的遍历方法
 * File[] listFiles() 遍历构造方法中传递目录
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("c:\\");
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
        System.out.println(files.length);
    }
}
