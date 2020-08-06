package com.itheima.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            //accept()方法,获取到客户端的连接对象Socket
            Socket socket = server.accept();//客户端使用浏览器连接
            InetAddress inetAddress = socket.getInetAddress();
            //获取客户端的主机名字,和IP地址
            System.out.println(inetAddress.getHostName()+"..."+inetAddress.getHostAddress());
            new Thread(new MyRunnable(socket)).start();
        }
    }
}
