package com.itheima.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  response对象,设置响应头
 *  数据指导客户端使用的
 *  格式k:v
 *
 *   void addHeader(String key,String value)设置响应头,传递字符串的键值对
 *   void addIntHeader(String key,int value)设置响应头,传递字符串的键,int的值
 *   void addDateHeader(String key,long time)设置响应头,传递字符串的键,值是毫秒值
 *
 *   void setHeader(String key,String value)设置响应头,传递字符串的键值对
 *   void setIntHeader(String key,int value)设置响应头,传递字符串的键,int的值
 *   void setDateHeader(String key,long time)设置响应头,传递字符串的键,值是毫秒值
 *
 *   区别:
 *     add 添加 : 一个键多个值
 *     set 设置 : 重复值,会覆盖
 *
 *     void setHeader(String key,String value)设置响应头,传递字符串的键值对
 */
@WebServlet(urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头
       /* response.addHeader("a","java");
        response.addIntHeader("b",123);
        response.addDateHeader("c",System.currentTimeMillis());*/

       response.setHeader("heima","java");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
