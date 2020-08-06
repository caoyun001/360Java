package com.itheima.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 实现图片上传服务器端
 * 实现步骤:
 *  1: 创建对象ServerSocket 绑定端口
 *  2: Socket accept()方法等待客户端连接
 *  3: Socket对象,获取字节输入流,读取客户端发来图片的字节
 *  4: 创建字节输出流,读取到图片,写到 e:/upload
 *  5: Socket对象,获取字节输出流,"上传成功"写回客户端
 *
 *
 *  bug:
 *    1: 演示了2次,为什么文件夹中只有一个文件,同名覆盖
 *      a: 1.jpg
 *      b: 1.jpg
 *
 *   2: 客户端收不到服务器的上传成功
 */
public class TCPServer {
    public static void main(String[] args) throws IOException{
        //1: 创建对象ServerSocket 绑定端口
        ServerSocket server = new ServerSocket(9000);
        // 2: Socket accept()方法等待客户端连接
        Socket socket = server.accept();
        //3: Socket对象,获取字节输入流,读取客户端发来图片的字节
        InputStream in = socket.getInputStream();
        //4: 创建字节输出流,读取到图片,写到 e:/upload
        //上传的文件,重命名,规则: itheima+毫秒值+随机数
        String filename ="itheima"+System.currentTimeMillis()+new Random().nextInt(99999999)+".jpg";

        FileOutputStream fos = new FileOutputStream("e:/upload/"+filename);
        byte[] bytes = new byte[1024];
        int len = 0;
        //read()读取是客户端写来的图片!!
        while ( (len = in.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        //5: Socket对象,获取字节输出流,"上传成功"写回客户端
        OutputStream out= socket.getOutputStream();
        out.write("上传成功!".getBytes());

        socket.close();
        server.close();
    }
}
