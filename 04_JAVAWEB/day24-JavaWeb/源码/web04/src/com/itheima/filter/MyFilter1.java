package com.itheima.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *  过滤器的快速入门
 *  1: 定义类实现接口 Filter
 *  2: 重写接口中的抽象方法
 *  3: web.xml配置
 *
 *  过滤器对象的生命周期
 *    1: 对象初始化创建,调用方法init
 *      方法参数 FilterConfig
 *      Tomcat引擎创建过滤器对象,并调用方法init传递参数
 *      Tomcat启动的时候,创建过滤器对象
 *
 *      方法参数 FilterConfig,过滤器配置对象
 *      可以获取到过滤器的 名字等等
 *      方法 getServletContext()获取到最大域对象
 *
 *    2: 拦截方法doFilter
 *      每次访问要拦截的对象,就运行
 *      访问了,非拦截对象,不运行
 *
 *    3: 对象销毁方法 destroy()
 *      关闭服务器的时候,过滤器对象销毁
 *      web项目,从服务器中移除
 */
public class MyFilter1 implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是过滤器1");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器对象被创建");
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器对象被销毁");
    }
}
