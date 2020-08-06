package com.itheima.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP通信的服务器程序
 * 192.168.27.95
 * java.net.ServerSocket 实现TCP协议中的服务器套接字对象
 *
 * 实现TCP服务器程序步骤:
 *   1: 创建ServerSocket对象
 *     ServerSocket(int port) 端口号
 *
 *   2: 等待客户端的连接,如果没有客户端连接,永远等待
 *     ServerSocket类方法 accept()同意
 *     方法 accept()返回值是 Socket对象 (客户端的连接对象,包含客户端的IP)
 *
 *   3: Socket对象中获取到字节输出流
 *     OutputStream getOutputStream()
 *     方法write写数据,写到客户端
 *
 *   4: Socket对象中获取到字节输入流
 *     InputStream getInputStream()
 *     方法read读取数据,读取的是客户端发来数据
 *
 *   5: 释放资源
 */
public class TCPServer {
    public static void main(String[] args)throws IOException {
        //创建ServerSocket对象
        ServerSocket server = new ServerSocket(9000);
        //ServerSocket类方法 accept()同意
        Socket socket = server.accept();
        //System.out.println(socket);

        //使用客户端连接获取对象,输入流
        InputStream in = socket.getInputStream();
        //in输入流的方法read()读取客户端发来数据
        byte[] bytes = new byte[1024];
        //len返回的是读取到的字节个数
        int len = in.read(bytes);
        System.out.println(new String(bytes,0,len));

        //Socket客户端对象,获取字节输出流
        OutputStream out = socket.getOutputStream();
        out.write("收到!".getBytes());//服务器输出流,写回客户端

        //释放资源
        socket.close();
        server.close();
    }
}
