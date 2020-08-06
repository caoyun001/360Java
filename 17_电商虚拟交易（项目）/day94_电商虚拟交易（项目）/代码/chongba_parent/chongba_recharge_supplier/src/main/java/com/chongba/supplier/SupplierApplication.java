package com.chongba.supplier;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 传智播客*黑马程序员.
 */
@SpringBootApplication
@MapperScan("com.chongba.recharge.mapper") //扫描操作订单的mapper
@EnableFeignClients(basePackages = {"com.chongba.feign"}) // 扫描feign接口所在的包
@ComponentScan({"com.chongba.cache","com.chongba.supplier"})
@EnableScheduling
public class SupplierApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class,args);
    }
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
