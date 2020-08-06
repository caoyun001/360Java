package com.itheima.server;

import java.io.*;
import java.net.Socket;

public class MyRunnable implements Runnable {

    private Socket socket;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //尝试: 用字节输入流,读取客户端发送来的数据
            InputStream inputStream = socket.getInputStream();
            //BufferedReader读取文本的一行
            //字节转成字符呢  InputStreamReader 字节转成字符
            InputStreamReader isr = new InputStreamReader(inputStream);
            //创建BufferedReader对象,构造方法中,传递isr字符流
            BufferedReader bfr = new BufferedReader(isr);
            String line = bfr.readLine();//GET /day14/web/index.html HTTP/1.1
            System.out.println(line);
            //分离字符串,切割,空格
            String[] strs = line.split(" ");
            //要数组的第1个索引
            String str = strs[1];
            //去掉字符串中最开始 /
            str = str.substring(1);
            //读取路径下的文件
            FileInputStream fis = new FileInputStream(str);
            //获取字节输出流,读取到文件写回客户端浏览器
            OutputStream out = socket.getOutputStream();
            //告知浏览器,写回去的是HTTP的协议,200,响应成功
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            //告诉浏览器,写回去的是网页形式文件,不是记事本
            out.write("Content-Type:text/html\r\n".getBytes());
            //单独写换行
            out.write("\r\n".getBytes());

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            fis.close();
            socket.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
