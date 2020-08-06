package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 注解开发过滤器
 *
 * 注解 @WebFilter
 * 属性 urlPatterns,配置的是拦截资源
 *
 * 注解过滤器之间的顺序,类名的自然顺序决定 a b c d 1 2 3 4
 * 不区分大小写
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("注解过滤器 myFilter3");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
