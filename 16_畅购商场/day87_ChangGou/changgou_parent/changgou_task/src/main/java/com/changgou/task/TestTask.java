package com.changgou.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class TestTask {

    //每一秒都要执行  cron = "* * * * * ?"
    //从每分钟的第5秒开始执行, 每增加5秒执行一次   cron = "5/5 * * * * ?"
    //每分钟的第5-20秒执行, 其他时间不执行  cron = "5-20 * * * * ?"
//    @Scheduled(cron = "5-20 * * * * ?")
//    public void task() {
//
//        System.out.println("=====================");
//    }
}
