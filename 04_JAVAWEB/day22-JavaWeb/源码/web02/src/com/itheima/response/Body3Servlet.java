package com.itheima.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  response对象获取的输出流,互斥
 *  字节的和字符互斥,只能使用一个
 *   response.getWriter()
 *   response.getOutputStream()
 *
 *   response对象缓冲区,数据都是先到缓冲区
 *   Servlet结束后,缓冲区数据,会写客户端浏览器
 */
@WebServlet(urlPatterns = "/body3")
public class Body3Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getOutputStream();
        response.getWriter();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
