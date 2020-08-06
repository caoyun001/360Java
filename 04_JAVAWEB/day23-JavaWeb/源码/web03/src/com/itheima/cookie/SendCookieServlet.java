package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Cookie对象: 小甜点
 *  Cookie对象是容器,存储数据,键值对
 *  数据产生在服务器端,数据放在客户端浏览器保存
 *  Cookie类构造方法:
 *    Cookie(String name,String value) 传递键值对
 *
 *    响应对象 response
 *    方法 addCookie( Cookie cookie )
 *    响应头中
 */
@WebServlet(urlPatterns = "/sendCookie")
public class SendCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象,存储键(名字)值对
        Cookie cookie =  new Cookie("heima","java");
        Cookie cookie2 =  new Cookie("heima2","java2");

        //响应对象,将Cookie数据,响应回客户端
        response.addCookie(cookie);
        response.addCookie(cookie2);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
