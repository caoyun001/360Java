package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 目标：实现提供者服务，根据id查询用户信息
 * 实体类
 * 三层架构：mapper、service、controller
 * 配置数据库的信息
 */
@SpringBootApplication
@EnableDiscoveryClient//开注册中心客户的自动配置
public class ProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args);
    }

}
