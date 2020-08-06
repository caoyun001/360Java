package com.itheima;

import com.itheima.config.MySelectImport;
import com.itheima.config.SpringConfiguration;
import com.itheima.service.UserService;
import com.itheima.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

//Import注解有三种导入对象的方式
//第一种：直接导入一个类
//@Import(UserServiceImpl.class)
//第二种：导入一个配置类，配置类中@Bean，会自动的批量导入对象
//@Import(SpringConfiguration.class)
//第三种：导入SelectImport接口的实现类对象，把批量的类全限定名称的类，注入到ioc容器
//@Import(MySelectImport.class)
@SpringBootApplication
public class Springboot3ImportAnnApplication {

    public static void main(String[] args) {
        //SpringApplication.run方法返回值是Spring的容器对象
        ConfigurableApplicationContext context = SpringApplication.run(Springboot3ImportAnnApplication.class, args);
        //从容器中，获取对象
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
    }

}
