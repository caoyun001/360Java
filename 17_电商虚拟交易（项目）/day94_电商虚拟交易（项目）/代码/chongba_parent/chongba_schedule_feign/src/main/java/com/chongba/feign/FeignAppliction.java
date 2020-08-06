package com.chongba.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by 传智播客*黑马程序员.
 */
@SpringBootApplication
@EnableFeignClients
public class FeignAppliction {
    
    public static void main(String[] args) {
        SpringApplication.run(FeignAppliction.class,args);
    }
}
