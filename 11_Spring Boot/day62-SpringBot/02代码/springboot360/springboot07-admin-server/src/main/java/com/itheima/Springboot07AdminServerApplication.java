package com.itheima;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer//开启SpringBoot admin的服务端支持
public class Springboot07AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07AdminServerApplication.class, args);
    }

}
