package com.itheima.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *  自定义监听器,监听对象(事件源) 域对象ServletContext
 *  域对象的创建和销毁
 *
 *  1: 定义类实现接口
 *  2: 重写抽象方法
 *  3: web.xml
 *
 *  ServletContext域对象,Tomcat服务器启动的时候被创建
 *  ServletContext域对象,Tomcat服务器关闭的时候被销毁
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{
    @Override
    /**
     * 当ServletContext对象被创建的时候,调用此方法
     * 方法中的参数 ServletContextEvent (域对象的事件对象) 什么都是对象
     * 时间对象是Tomcat引擎创建,调用方法contextInitialized传递的
     * 方法:
     *   ServletContext getServletContext() 获取ServletContext域对象
     *   域对象称为事件源
     *
     *  任意一个监听器,都可以使用方法参数中的事件对象,获取事件源
     *
     *   Object source = servletContextEvent.getSource();获取事件源
     *   返回的是Object,强制转换
     *   任意一个监听器,都可以使用方法参数中的事件对象,共同的方法 getSource()
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建");
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println("事件源::"+servletContext);

      //  Object source = servletContextEvent.getSource();
    }

    @Override
    /**
     * 当ServletContext对象被销毁的时候,调用此方法
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁");
    }
}
