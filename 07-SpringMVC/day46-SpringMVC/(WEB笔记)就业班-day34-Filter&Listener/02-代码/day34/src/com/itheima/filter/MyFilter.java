package com.itheima.filter;

import javax.servlet.*;
import java.io.IOException;
/**
 * @author likepei
 * @data 2019/7/16 8:49
 * @description Filter的入门程序
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init 执行了 ");
    }

    /**
     * 执行Filter 过滤数据的方法
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter 执行了 ");

        //放行操作, 执行后续的访问操作
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroy 执行了 ");
    }
}
