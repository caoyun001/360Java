package com.itheima.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * request请求对象
 *   客户的所有请求数据,都是由此对象来获取
 *   接口 ServletRequest
 *     适合于任何的网络协议,与协议无关的接口
 *     网络协议基本都是HTTP
 *
 *   子接口 HttpServletRequest
 *   使用的是子接口HttpServletRequest对象
 *   是Tomcat引擎创建,调用方法的时候传递参数
 *
 *   客户端的请求:
 *     请求行
 *     请求头
 *     请求体
 */
@WebServlet(urlPatterns = "/r")
public class RequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
