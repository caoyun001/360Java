package com.itheima.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  浏览器重定向: response对象非常重要的应用
 *  接收客户端的请求
 *    让客户端浏览器重新定向另一个Servlet
 *    状态码302
 *    告知浏览器要访问的下一个Servlet的地址
 *    指导浏览器干活
 *
 *    设置响应头
 *
 *    浏览器第一次请求  /web02/servlet1
 *       响应302  和 地址
 *
 *   浏览器主动发起第二次请求 /web02/servlet2
 *   浏览器地址栏改变!!
 *
 *   Sun公司很善良:
 *     合成一个方法
 *     response对象的方法 sendRedirect(地址)
 */
@WebServlet(urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(302);
        //设置响应头   告知浏览器要访问的下一个Servlet的地址 (带上Web应用程序的名字)
        //response.setHeader("location","/web02/servlet2");

        response.sendRedirect("/web02/servlet2");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
