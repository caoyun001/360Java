package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot的启动引导类
 * @Configuration 配置类注解，表明当前类是一个配置类
 * @ComponentScan 包扫描注解：不写包扫描的配置basePackages，扫描当前包及其子包
 *
 * @EnableAutoConfiguration 开启自动的配置
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DemoApplication {

    public static void main(String[] args) {
        /**
         * SpringBoot应用程序的入口
         * 参数：SpringApplication.run("启动引导类的字节码文件", "主函数的参数")
         * 返回值是一个Spring的容器
         */
        SpringApplication.run(DemoApplication.class, args);
    }
}
