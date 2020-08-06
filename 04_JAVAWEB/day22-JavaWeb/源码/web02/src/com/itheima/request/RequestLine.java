package com.itheima.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  客户端的请求行
 *  包含:
 *    请求方式,请求服务器地址,协议版本
 *
 *  request对象的方法:
 *    String getMethod() 获取的是客户端请求方式  GET,POST
 *      GET: 地址栏直接输入地址,都是GET请求
 *      a href="" 也是GET请求
 *
 *   //获取客户端请求服务器的地址
 *    StringBuffer getRequestURL()
 *    String getRequestURI()
 *    String getContextPath()  获取web程序的名字,常用
 *
 *    获取客户端请求的数据
 *    注意: 适用于GET请求方式,获取的是服务器地址 ? 后面的参数
 *    String getQueryString()
 */
@WebServlet(urlPatterns = "/requestLine")
public class RequestLine extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println("客户端的请求方式::"+method);

        //获取客户端请求服务器的地址
        StringBuffer url = request.getRequestURL();
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println("url::"+url);// http://localhost:8080/web02/requestLine 协议,端口,web应用名称,Servlet路径
        System.out.println("uri::"+uri);// /web02/requestLine     web应用名称,Servlet路径
        System.out.println("contextPath::"+contextPath);//  /web02  web应用名称

        String query = request.getQueryString();
        System.out.println("query::"+query); //  user=admin   pass=123
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
