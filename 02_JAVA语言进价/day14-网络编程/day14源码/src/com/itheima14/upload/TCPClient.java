package com.itheima.upload;

import java.io.*;
import java.net.Socket;

/**
 * 实现TCP图片上传客户端
 * 实现步骤:
 *  1: 创建Socket对象,连接服务器
 *  2: FileInputStream读取 mm.jpg   字节数组
 *  3: Socket对象获取字节输出流
 *     字节数组,交给输出流,写到服务器
 *  4: Socket对象获取字节输入流
 *     全部的图片发送完毕
 *     输入流,读取服务器回来的提示信息 "上传成功"
 *
 *     客户端方法Socket: shutdownOutput() 终止连接对象的输出流 ,
 *     同时跟上TCP终止序列
 *  5: 释放资源
 */
public class TCPClient {
    public static void main(String[] args) throws IOException{
        //1: 创建Socket对象,连接服务器
        Socket socket = new Socket("127.0.0.1",9000);
        //2: 自己的字节输入流,读取图片mm.jpg
        FileInputStream fis = new FileInputStream("g:/mm.jpg");
        //3: Socket对象获取字节输出流
        OutputStream out = socket.getOutputStream();//任何数据,写向服务器
        byte[] bytes = new byte[1024];
        int len = 0;
        //fis读取文件末尾,JVM返回read() -1
        while ((len = fis.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        //告诉服务器,没数据了,别读,服务器发送TCP的终止符
        socket.shutdownOutput();
        //4:Socket对象获取字节输入流
        InputStream in = socket.getInputStream();//输入流,读取服务器回来的数据
        len = in.read(bytes);
        System.out.println("服务器提示::"+new String(bytes,0,len));

        socket.close();
    }
}
