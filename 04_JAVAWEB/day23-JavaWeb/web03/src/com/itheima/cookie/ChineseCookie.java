package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *  Cookie可以存储中文数据的,不建议
 *  键不能是中,值可以是中文
 *
 *  Tomcat8.5版本开始,可以直接使用中文的
 *  8.5版本之前,不允许直接写中文的
 *
 *  中文 转码UTF-8码, -4 -5 -6   转成十六进制  A1%E3%F1
 */
@WebServlet(urlPatterns = "/chineseCookie")
public class ChineseCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "中文";
        str =  URLEncoder.encode(str,"utf-8");
        System.out.println(str); //  %E4%B8%AD%E6%96%87

        /*Cookie cookie = new Cookie("china",str);
        response.addCookie(cookie);*/

       Cookie[] cookies = request.getCookies();
       for(Cookie cookie : cookies){
           String value = URLDecoder.decode(cookie.getValue(),"utf-8");
           System.out.println(  cookie.getName()+"::"+value );
       }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
