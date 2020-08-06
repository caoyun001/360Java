package com.chongba.schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ScheduledFuture;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
public class DynamicTaskTest {
    private final static Logger logger = LoggerFactory.getLogger(DynamicTaskTest.class);
    @Autowired
    private  ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Test
    public  void testCron() {
        String cron = "0 */1 * * * ?";//区别于: String cron = "* */1 * * * ?"
        threadPoolTaskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule time-" + (System.currentTimeMillis() / 1000));
            }
        }, new CronTrigger(cron));
        System.out.println("开始执行schedule"+(System.currentTimeMillis()/1000));
        while (true){
        }
    }

    @Test
    public void testFixedSchedule(){
        ScheduledFuture<?> future = threadPoolTaskScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate time-" + (System.currentTimeMillis() / 1000));
            }
        }, 1000);
        System.out.println("开始执行scheduleAtFixedRate"+(System.currentTimeMillis()/1000));
        future.cancel(true);
        while (true){

        }
    }
}