package com.itheima.springboot02faster;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * war包，程序的入口
 * 相当于WEB-INF/web.xml配置文件
 */
public class ServletInitializr extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //将当前的启动引导类字节码文件，设置到sources方法中
        return builder.sources(Springboot02FasterApplication.class);
    }
}
