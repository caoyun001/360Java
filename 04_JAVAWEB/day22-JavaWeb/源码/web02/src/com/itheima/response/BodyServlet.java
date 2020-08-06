package com.itheima.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * response设置响应体:
 *   是浏览器展示的页面正文
 *   网络数据传递IO传递
 *
 *   响应体字符输出流
 *   response方法 getWriter()返回打印流对象, PrintWriter
 *   字符流,只能输出文本数据
 */
@WebServlet(urlPatterns = "/body")
public class BodyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("haha");
        writer.println(123);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
