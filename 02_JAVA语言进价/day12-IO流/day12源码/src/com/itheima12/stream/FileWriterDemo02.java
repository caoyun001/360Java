package com.itheima.stream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字节流写入数据: 追加和换行
 * 流对象构造方法,第二个参数true
 * 换行问题:
 *   Windows:  \r\n
 *   Linux:    \n
 *   Mac:      \r
 */
public class FileWriterDemo02 {
    public static void main(String[] args) throws IOException{
        //追加写入
        FileWriter fw = new FileWriter("e:/456.txt",true);
        fw.write("第一行\r\n");
        fw.write("第二行");
        fw.close();
    }
}
