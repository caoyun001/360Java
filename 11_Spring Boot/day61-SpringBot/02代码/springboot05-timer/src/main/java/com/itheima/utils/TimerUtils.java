package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时器任务类：定时向控制台输出当前系统的时间
 * 定时器任务处理类，一定要注入Spring的容器中
 */
@Component
public class TimerUtils {
    //注入service层的接口实现类对象
//    @Autowired
//    private UserService userService;

    /**
     * @Scheduled 设置当前方法执行的规则
     * cron属性，设置通用时间规则
     *
     * initialDelay：处事当前服务之后，延迟多长时间执行
     * fixedDelay：以一个固定的延迟时间执行，上一个任务完成之后，多久，下一个任务执行
     * fixedRate：以一个固定的频率执行，不管上一个任务执行的时间
     */
    @Scheduled(fixedDelay = 2000)
    public void mytask(){
        //写业务逻辑
        System.out.println(new Date());
    }
}
