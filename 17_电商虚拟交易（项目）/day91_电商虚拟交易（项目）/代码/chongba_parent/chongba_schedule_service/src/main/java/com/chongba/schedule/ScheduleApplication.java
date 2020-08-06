package com.chongba.schedule;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by 传智播客*黑马程序员.
 */
@SpringBootApplication
@ComponentScan({"com.chongba.schedule","com.chongba.cache"})
@MapperScan("com.chongba.schedule.mapper")
@EnableScheduling
public class ScheduleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class,args);
    }
    
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
