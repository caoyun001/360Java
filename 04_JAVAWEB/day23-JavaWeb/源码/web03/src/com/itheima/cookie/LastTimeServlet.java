package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  记录客户端上一次访问时间: Cookie数据的读取和响应
 *  实现思想:
 *    1: 获取客户端携带Cookie数据
 *    2: 判断获取的结果
 *      A: 没有Cookie
 *        响应欢迎语
 *        创建Cookie,值是当前的时间
 *        响应回客户端
 *
 *      B: 有Cookie
 *        获取Cookie中的键值对,值就是客户端上次访问的时间
 *        响应客户端 (上次访问时间)
 *        创建Cookie,值是当前的时间
 *        响应回客户端
 */
@WebServlet(urlPatterns = "/lastTime")
public class LastTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        //设置响应,处理中文乱码
        response.setContentType("text/html;charset=utf-8");
        // 1: 获取客户端携带Cookie数据
        Cookie[] cookies = request.getCookies();
        //2: 判断获取的结果
        if(cookies == null){
            //客户端是第一次访问
            response.getWriter().write("欢迎首次访问");
            //Cookie,记录现在时间(格式化)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String time = sdf.format(new Date());
            Cookie cookie = new Cookie("time",time);
            cookie.setMaxAge(60*10);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }else {
            //客户端不是第一次访问,取出Cookie中的键值对
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();//值就是上次的访问时间
                //响应客户端上次访问时间
                response.getWriter().write("上一次访问的时间是::"+value);
                //Cookie,记录现在时间(格式化)
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
                String time = sdf.format(new Date());
                Cookie newCookie = new Cookie("time",time);
                newCookie.setMaxAge(60*10);
                newCookie.setPath(request.getContextPath());
                response.addCookie(newCookie);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
