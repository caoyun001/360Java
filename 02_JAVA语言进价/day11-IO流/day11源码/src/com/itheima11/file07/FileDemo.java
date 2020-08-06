package com.itheima.file07;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件的过滤器
 *   过滤出我们需要的文件
 *
 *   遍历方法 listFiles()具有重载形式
 *   listFiles( FileFilter fileFilter)传递参数FileFilter类型对象(文件过滤器)
 *   java.io.FileFilter接口
 *   自己创建FileFilter接口实现类,实现接口,重写方法
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("c:\\abc");
        //调用方法listFiles(传递接口FileFilter接口实现类对象)
        File[] files = file.listFiles( new FileFilter(){
            public boolean accept(File pathname){
                return pathname.toString().endsWith(".java");
            }
        });
        for(File f:files){
        System.out.println(f);
    }
}
}

class MyFilter implements FileFilter{
    //参数pathname,遍历的目录中的文件路径    c:\abc\1.docx
    public boolean accept(File pathname){
        //如果路径的结尾是.java 返回true,否则返回false
        //String类方法 endsWith(".java")
      /*  String path = pathname.toString();
        return path.endsWith(".java");*/

        return pathname.toString().endsWith(".java");
       // return true;
    }

}
