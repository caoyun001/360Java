package com.itheima.file08;

import java.io.File;

/**
 * File对象的方法: 目录中的所有内容全遍历
 * 定义方法,遍历指定目录,传递谁,遍历谁
 *
 */
public class FileDemo {
    public static void main(String[] args) {
        getAll( new File("c:\\java"));
    }
    /**
     * 定义方法,遍历指定目录,传递谁,遍历谁
     * 方法的参数,就是未知的路径 File
     * dir: c:\\abc
     * 在abc目录下,还有子目录 bbc 遍历
     */
    public static void getAll(File dir){
        System.out.println(dir);
        File[] files =  dir.listFiles();
        for(File file : files){
           //判断file数组元素,是不是一个文件夹的路径
            if(file.isDirectory()){
                //c:\abc\bbc 继续遍历, getAll()传递路径,遍历,调用自己
                getAll(file);
            }else{
                System.out.println(file);
            }
        }
    }
}
