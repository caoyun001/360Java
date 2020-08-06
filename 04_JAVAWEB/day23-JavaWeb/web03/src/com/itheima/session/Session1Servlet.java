package com.itheima.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  session对象
 *  接口: HttpSession, 是接口的实现类对象
 *  此接口实现类是Tomcat引擎创建
 *  获取使用即可
 *    request对象方法 getSession()
 *    org.apache.catalina.session.StandardSessionFacade
 *
 *  session域对象,容器存储数据
 *   域对象的方法  (JavaWeb中包含的4个域对象):
 *    void setAttribute(String key, Object value)键值对存储在域对象
 *    Object getAttribute(String key)取出键对应的值
 *    void removeAttribute(String key)移除键值对
 *
 *   session域对象的作用范围: 一次会话有效
 *   浏览器不关闭,有效的,和请求次数无关的
 *
 *   ServletContext > session > request > pageContext
 *
 */
@WebServlet(urlPatterns = "/session1")
public class Session1Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取HttpSession接口实现类对象
        HttpSession session =  request.getSession();
        //向session域对象存储键值对
        session.setAttribute("ses","sesValue");
        //取出session域对象的数据
        Object o = session.getAttribute("ses");
        System.out.println(o);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
