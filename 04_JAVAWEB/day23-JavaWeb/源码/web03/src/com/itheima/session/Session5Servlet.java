package com.itheima.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session域对象的销毁
 * 1: 服务器Tomcat,默认的配置, 30分钟销毁
 *   自定义session销毁时间,自己在web.xml中配置
 *
 * 2: session域对象方法:
 *   invalidate()程序人员调用次方法,session对象销毁
 */
@WebServlet(urlPatterns = "/session5")
public class Session5Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =  request.getSession();
        session.invalidate();

        Object o = session.getAttribute("heima");
        System.out.println("session5::"+o);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
