package com.itheima.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  session域对象的ID值
 *  唯一性
 *  session对象方法 getId()返回值是String
 *
 *  session域对象的持久化:
 *    本身持久化的不是Session,持久化的是Cookie
 *    客户端浏览器保存cookie,Cookie中存储的是session对象的ID
 *
 *    客户端关闭后,存储的session的ID依然存在,访问服务器,通过session的id来找到域对象
 */
@WebServlet(urlPatterns = "/session3")
public class Session3Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getSession().getId();
        //Session域对象中存储数据
        request.getSession().setAttribute("heima","java");

        System.out.println("sessionid=="+id);
        //创建Cookie对象,存储sessionid
        Cookie cookie = new Cookie("JSESSIONID",id);
        //设置生存时间
        cookie.setMaxAge(60*10);
        //携带路径
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
