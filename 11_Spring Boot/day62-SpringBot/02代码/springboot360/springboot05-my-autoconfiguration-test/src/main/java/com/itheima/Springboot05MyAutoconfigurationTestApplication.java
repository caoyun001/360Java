package com.itheima;

import cn.itcast.utils.CodeUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot05MyAutoconfigurationTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot05MyAutoconfigurationTestApplication.class, args);

        CodeUtils codeUtils = context.getBean(CodeUtils.class);

        codeUtils.generatorCode();

    }

}
