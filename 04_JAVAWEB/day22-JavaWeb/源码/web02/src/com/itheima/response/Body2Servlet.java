package com.itheima.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  response设置响应体:
 *   是浏览器展示的页面正文
 *   网络数据传递IO传递
 *
 *   字节输出流: (全能)
 *   response对象方法 getOutputStream()返回字节输出流
 */
@WebServlet(urlPatterns = "/body2")
public class Body2Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        //字节流,写数据,字节或者字节数组

        //获取图片2.jpg的绝对路径,先要获取到ServletContext对象
        ServletContext context = getServletContext();
        String path = context.getRealPath("WEB-INF/2.jpg");
        //字节输入流,读取图片
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ( (len = fis.read(bytes))!=-1 ){
            outputStream.write(bytes,0,len);
        }
        fis.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
