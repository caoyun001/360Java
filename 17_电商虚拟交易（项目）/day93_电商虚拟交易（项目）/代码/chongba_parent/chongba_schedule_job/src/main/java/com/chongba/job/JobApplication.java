package com.chongba.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by 传智播客*黑马程序员.
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.chongba.feign"})
@EnableScheduling
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class,args);
    }
}
