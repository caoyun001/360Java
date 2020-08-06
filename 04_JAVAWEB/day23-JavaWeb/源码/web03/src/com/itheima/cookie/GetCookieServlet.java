package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  获取客户端的Cookie数据
 *  客户端访问服务器的时候,会有Cookie数据
 *  浏览器会将Cookie数据,放在HTTP协议的请求头中
 *  request对象获取请求头数据 (Cookie)
 *  方法: Cookie[] getCookies() 获取到浏览器中的Cookie,返回的是数组
 *
 *  浏览器中没有了Cookie(手动删除),request对象获取不到Cookie,返回的数组null
 */
@WebServlet(urlPatterns = "/getCookie")
public class GetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端的Cookie数据
       Cookie[] cookies = request.getCookies();
       //遍历数组,取出Cookie中的键和值
        for(Cookie cookie : cookies){
            //取出的是每个Cookie对象
            String name = cookie.getName();//Cookie中的键
            String value = cookie.getValue();//Cookie中的值
            System.out.println(name+"::"+value);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
