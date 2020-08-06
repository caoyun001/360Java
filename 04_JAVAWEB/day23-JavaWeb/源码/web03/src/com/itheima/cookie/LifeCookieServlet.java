package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Cookie的生命周期
 *
 *  Cookie是会话对象
 *  会话(浏览器访问服务器,不关闭浏览器,一次会话)
 *  一旦关闭浏览器,Cookie对象就死亡
 *
 *  设置Cookie的生存时间
 *  Cookie对象方法 setMaxAge(int 秒)
 *  Cookie过时时间,到时间,没有删除它,而是不会在携带访问
 */
@WebServlet(urlPatterns = "/lifeCookie")
public class LifeCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("heima","java");
        //Cookie携带路径
        cookie.setPath( request.getContextPath() );

        //设置Cookie的生存时间
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
