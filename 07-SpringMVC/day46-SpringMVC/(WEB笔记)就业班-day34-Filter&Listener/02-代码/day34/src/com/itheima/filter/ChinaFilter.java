package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author likepei
 * @data 2019/7/16 9:14
 * @description Filter的注解编写方式 (当前web项目的 全局中文乱码的问题)
 */
//@WebFilter(urlPatterns = "/*")
//@WebFilter(value = "/*")
@WebFilter("/*")
public class ChinaFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //设置中文编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        System.out.println("ChinaFilter 执行了, 设置使用 utf-8编码, 用于处理中文编码");
        //放行, 可以访问后续的操作
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
