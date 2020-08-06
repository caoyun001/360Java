package com.itheima.filer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/resource/*")
public class loginFilter implements Filter {

    @Override
    /**
     * 登录的过滤.如果登录,直接放行
     * 没有登录,退到登录页面去
     * 客户端是否登录,取决于Session域对象
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //取出session域对象的值
        //ServletRequest转成子接口
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        //ServletResponse转成子接口
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String username =(String) request.getSession().getAttribute("username");
        if (username == null){
            //没有登录,退到登录页面去
            request.setAttribute("message","请先登录,再访问");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //登录状态直接放行
            filterChain.doFilter(request,response);
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }
}
