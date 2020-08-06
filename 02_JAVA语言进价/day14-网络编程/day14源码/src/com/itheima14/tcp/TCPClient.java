package com.itheima.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 实现TCP通信的客户端程序
 *
 * java.net.Socket 实现客户端的套接字对象,连接对象
 *
 * 需求: 客户端程序和服务器程序实现数据交换
 *
 * 实现步骤:
 *   1: 创建Socket对象 (主动连接服务器)
 *        Socket(String host, int port)
 *
 *   2: OutputStream getOutputStream()
 *      返回套接字中的字节输出流
 *      方法write写入数据, 写到服务器
 *
 *   3: InputStream getInputStream()
 *      返回套接字中的字节输入流
 *       方法read读取数据,读取的是服务器发回来的数据
 *
 *   4: 释放资源
 */
public class TCPClient {
    public static void main(String[] args)throws IOException {
        //创建Socket对象 (主动连接服务器)
        Socket socket = new Socket("127.0.0.1",9000);

        //OutputStream getOutputStream()
        OutputStream out = socket.getOutputStream();
        //字节流的方法写数据
        out.write("你好服务器".getBytes());//没有写到文件中,写到了服务器中

        InputStream  in = socket.getInputStream();//获取字节输入流
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);//客户端输入流,读取到服务器发回来的数据
        System.out.println(new String(bytes,0,len));

        //释放资源
        //out.close();
        socket.close();
    }
}
