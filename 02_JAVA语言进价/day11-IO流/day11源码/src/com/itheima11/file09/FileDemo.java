package com.itheima.file09;

import java.io.File;
import java.io.FileFilter;

/**
 * 遍历目录,全遍历
 * 要目录中的.java文件
 */
public class FileDemo {
    public static void main(String[] args) {
        getAll(new File("c:\\abc"));
    }

    /**
     *  c:\abc\1.docx
     c:\abc\A.java
     c:\abc\B.java
     c:\abc\bbc
     */

    public static void getAll(File dir){
        File[] files = dir.listFiles(new MyJavaFilter() );
        for(File file : files){
            //判断file对象是不是目录
            if(file.isDirectory()){
                //递归,继续遍历
                getAll(file);
            }else {
                System.out.println(file);
            }
        }
    }
}

class MyJavaFilter implements FileFilter{
    public boolean accept(File pathname) {
        //pathname路径,是目录,直接放行,不能过滤
        if(pathname.isDirectory()) // c:\abc\bbc
            return true;

        //c:\abc\1.docx  参数路径,判断是不是.java结尾
        return pathname.toString().endsWith(".java");
    }
}
