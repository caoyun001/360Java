package com.itheima.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  response对象响应中文乱码
 *  为什么出现乱码:
 *    数据写在response对象缓冲区
 *    使用的编码表是 iso8859-1
 *
 *    修改response对象的编码表
 *    response对象方法 setCharacterEncoding
 *    一定要在流对象开启之前设置
 *
 *    浏览器默认的解码使用编码表,操作系统的默认GBK
 *    告诉浏览器,使用utf-8解码
 *    <meta charset="utf-8">
 *
 *    response提供方法 setContentType() 设置的是响应头
 *    指导性信息,指导浏览器
 */
@WebServlet(urlPatterns = "/body4")
public class Body4Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //修改response对象的编码表
        /*response.setCharacterEncoding("utf-8");
        response.getWriter().write("<meta charset=\"utf-8\">");*/
        response.setContentType("text/html;charset=utf-8");//设置响应内容类型
        response.getWriter().write("你好");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
