package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Springboot06RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06RestTemplateApplication.class, args);
    }

    //注入RestTemplate对象到Spring的容器中
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
