package com.itheima.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  response对象,负责向客户端响应数据的对象
 *  Sun接口:
 *    ServletResponse接口
 *    适用任何网络传输协议
 *
 *    目前传输协议都是HTTP协议,专门使用HTTP协议
 *    做了一个子接口HttpServletResponse
 *    使用的对象是子接口HttpServletResponse的实现类对象
 *    此实现类对象,是Tomcat引擎创建,调用方法doGet传递参数
 *
 *    客户端响应:
 *      响应行;  协议名 状态码
 *      响应头:  键值对格式 数据k:v的形式
 *      响应体:  页面正文,浏览器显示
 */
@WebServlet(urlPatterns = "")
public class ResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
