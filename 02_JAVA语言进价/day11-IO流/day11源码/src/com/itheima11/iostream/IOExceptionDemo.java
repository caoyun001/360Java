package com.itheima.iostream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  IO异常处理
 *
 *  new FileOutputStream("a.txt") 文件在工程根目录下
 *  new FileOutputStream("day11/a.txt"); 文件当前模块下
 */
public class IOExceptionDemo {
    public static void main(String[] args) {
        //try外声明变量,try里,创建对象
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("day11/a.txt");
            fos.write(97);
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                if(fos != null)
                    fos.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
