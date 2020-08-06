package com.itheima.threadupload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class MyRunnable implements Runnable {

    private Socket socket ;

    public MyRunnable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //3: Socket对象,获取字节输入流,读取客户端发来图片的字节
            InputStream in = socket.getInputStream();
            //4: 创建字节输出流,读取到图片,写到 e:/upload
            //上传的文件,重命名,规则: itheima+毫秒值+随机数
            String filename = "itheima" + System.currentTimeMillis() + new Random().nextInt(99999999) + ".jpg";

            FileOutputStream fos = new FileOutputStream("e:/upload/" + filename);
            byte[] bytes = new byte[1024];
            int len = 0;
            //read()读取是客户端写来的图片!!
            while ((len = in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            //5: Socket对象,获取字节输出流,"上传成功"写回客户端
            OutputStream out = socket.getOutputStream();
            out.write("上传成功!".getBytes());
            fos.close();
            socket.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
