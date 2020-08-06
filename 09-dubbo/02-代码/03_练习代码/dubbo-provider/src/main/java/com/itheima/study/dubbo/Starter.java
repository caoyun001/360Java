package com.itheima.study.dubbo;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ：zhang
 * @date ：Created in 2019/11/25
 * @description ：启动类
 * @version: 1.0
 */
public class Starter {
    public static void main(String[] args) throws IOException {
        //1 - 手动加载配置文件
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo.xml");
//        context.start();
//        System.in.read();
        //2 - MAIN启动

        System.setProperty("dubbo.spring.config","classpath:spring-dubbo.xml");
        Main.main(null);


    }
}
