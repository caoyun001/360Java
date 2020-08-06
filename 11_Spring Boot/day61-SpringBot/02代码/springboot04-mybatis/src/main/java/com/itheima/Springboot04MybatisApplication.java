package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @MapperScan扫描Mybatis的接口及其动态代理实现类
 */
@SpringBootApplication
//@MapperScan(basePackages = "com.itheima.mapper")
public class Springboot04MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04MybatisApplication.class, args);
    }

}
