package com.itheima.server;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 读取port.xml,获取出端口号
 * 交给服务器程序启动
 */
public class Server {
    public static void main(String[] args)throws Exception {
        InputStream inputStream = Server.class.getClassLoader().getResourceAsStream("port.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        //使用xpath表达式,直接获取标签port
        Element portElement = (Element)rootElement.selectSingleNode("//port");
        //获取标签体
        int port = Integer.parseInt(portElement.getText());

        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            new Thread(new MyRunnable(socket)).start();
        }
    }
}
