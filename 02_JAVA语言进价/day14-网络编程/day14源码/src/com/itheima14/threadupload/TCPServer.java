package com.itheima.threadupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 实现多线程上传的程序
 */
public class TCPServer {
    public static void main(String[] args) throws IOException{
        //创建ServerSocket对象,占用端口
        ServerSocket server = new ServerSocket(9000);
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(10);

        //等待客户端连接
        while (true) {
            Socket socket = server.accept();
            //开启线程
            //new Thread(new MyRunnable(socket)).start();
            service.submit(new MyRunnable(socket));
        }
    }
}
/**
 //创建ServerSocket对象,占用端口
 ServerSocket server = new ServerSocket(9000);
 //等待客户端连接
 while (true) {
 Socket socket = server.accept();
 //开启线程
 new Thread(new MyRunnable(socket)).start();
 }
 */