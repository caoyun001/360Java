package com.itheima.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  request对象也是个域对象
 *  和上午的ServletContext相同,都是域对象,都可以存储数据
 *  但是: 作用域不同
 *    ServletContext对象作用域最大,整个web程序都是有效的
 *    request对象作用于相对小,是一次请求有效,再一次请求无效
 *
 *    域对象的方法  (JavaWeb中包含的4个域对象):
 *    void setAttribute(String key, Object value)键值对存储在域对象
 *    Object getAttribute(String key)取出键对应的值
 *    void removeAttribute(String key)移除键值对
 *
 *    转发:
 *      request对象方法: getRequestDispatcher("转发后的路径")返回接口RequestDispatcher
 *      接口RequestDispatcher 转发器对象
 *      接口方法 forward
 */
@WebServlet(urlPatterns = "/request1")
public class Request1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request域对象中,存储键值对
        request.setAttribute("java","heima");
        //取出值
        Object o = request.getAttribute("java");
        System.out.println(o);

        //进行转发,到request2中
        RequestDispatcher dispatcher = request.getRequestDispatcher("/request2");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
