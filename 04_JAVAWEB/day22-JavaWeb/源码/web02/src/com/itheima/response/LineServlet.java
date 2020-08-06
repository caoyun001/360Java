package com.itheima.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现response对象设置响应行
 * 状态码
 *   response对象方法: setStatus(int 状态码)
 *
 *   Tomcat引擎,会自动识别程序的运行结果
 *   根据结果自己设置状态码
 */
@WebServlet(urlPatterns = "/line")
public class LineServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置状态码
        response.setStatus(500);
//        int a = 1/0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
