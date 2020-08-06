package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Cookie的携带路径
 *    浏览器访问服务器 , 是否携带Cookie访问?
 *
 *    结论: Cookie数据在哪里产生的,在哪里访问才携带
 *
 *    演示:
 *      浏览器先访问的是 /web03/pathCookie
 *      第二次访问的是 /web03/pathCookie
 *      第三次访问的是 /web03/a.jsp
 *      第四次访问的是 /web03/abc/b.jsp
 *
 *      浏览器都携带Cookie数据  (请求头有!)
 *      Cookie的数据是在哪个路径下产生的呢:  /web03
 *      凡是访问的是 /web03的下的任意资源,都携带
 *
 *     演示:
 *       浏览器先访问的是 /web03/abc/pathCookie  (请求头有!)
 *       第二次访问的是   /web03/abc/pathCookie  (请求头有!)
 *       第三次访问的是   /web03/abc/b.jsp  (请求头有!)
 *       第四次访问的是   /web03/a.jsp  (请求没有!)
 *
 *       Cookie的产生路径: /web03/abc
 *       凡是访问的是 /web03/abc 下的任意资源,都携带
 *       最后一次,访问的是 /web03/a.jsp 浏览器没有携带Cookie
 *
 *       我们开发中,需要的是只要Cookie访问的是/web03就要携带
 *       不管你是在哪里产生
 *
 *       Cookie对象的方法设置Cookie的携带路径: setPath
 */
@WebServlet(urlPatterns = "/abc/pathCookie")
public class PathCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("path","cookiePath");
        //设置Cookie携带路径,只要是/web03就携带
        //写的是web应用程序名称  request对象方法 getContextPath()
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
