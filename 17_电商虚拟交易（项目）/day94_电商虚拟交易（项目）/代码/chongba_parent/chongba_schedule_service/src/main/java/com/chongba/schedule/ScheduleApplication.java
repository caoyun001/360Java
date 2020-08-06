package com.chongba.schedule;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.chongba.schedule.service.VisiableThreadPool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by 传智播客*黑马程序员.
 */
@SpringBootApplication
@ComponentScan({"com.chongba.schedule","com.chongba.cache"})
@MapperScan("com.chongba.schedule.mapper")
@EnableScheduling
@EnableAsync
public class ScheduleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class,args);
    }
    
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
    
    
    @Bean
    public ThreadPoolTaskExecutor mythreadpool(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(5);
        //设置最大线程数
        taskExecutor.setMaxPoolSize(100);
        //设置线程空闲等待时间
        taskExecutor.setKeepAliveSeconds(60);
        //设置任务等待队列的大小
        taskExecutor.setQueueCapacity(60);
        // 设置线程池内线程名称的前缀-------阿里编码规约推荐--方便出错后进行调试
        taskExecutor.setThreadNamePrefix("mythreadpool-");
        //设置任务的拒绝策略
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //初始化
        taskExecutor.initialize();
        return taskExecutor;
    }


    @Bean("visiableThreadPool")
    public ThreadPoolTaskExecutor visiableThreadPool(){
        ThreadPoolTaskExecutor visiableThreadPool = new VisiableThreadPool();
        visiableThreadPool.setCorePoolSize(10);
        visiableThreadPool.setMaxPoolSize(1000);
        visiableThreadPool.setKeepAliveSeconds(60);
        visiableThreadPool.setQueueCapacity(1000);
        visiableThreadPool.setThreadNamePrefix("visiableThreadPool-");
        visiableThreadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        visiableThreadPool.initialize();
        return visiableThreadPool;
    }
}
