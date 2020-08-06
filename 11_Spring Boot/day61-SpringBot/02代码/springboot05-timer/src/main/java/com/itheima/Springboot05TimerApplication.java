package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Enable**
 * @Configuration与@Import的整合
 */
@SpringBootApplication
@EnableScheduling//开启SpringBoot的定时期功能支持
public class Springboot05TimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05TimerApplication.class, args);
    }

}
