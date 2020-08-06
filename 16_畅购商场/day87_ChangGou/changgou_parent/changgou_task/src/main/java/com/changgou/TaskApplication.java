package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 */
@SpringBootApplication
//这个注解作用是开启定时器, 如果不写这个注解, 在方法中写cron表达式是不起作用的
@EnableScheduling
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run( TaskApplication.class,args );
    }
}
