package com.chongba.schedule.executor;

import com.chongba.schedule.ScheduleApplication;
import com.chongba.schedule.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 传智播客*黑马程序员.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
public class ThreadPoolTaskExecutorTest {
    
    // @Autowired
    @Resource(name = "visiableThreadPool")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    
    @Autowired
    private AsyncTask asyncTask;
    
    @Test
    public void test(){
        
        //向线程池内提交100个任务
        for(int i=0;i<100;i++){
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ThreadPoolTaskExecutor test  "+ Thread.currentThread().getName());
                }
            });
        }
        System.out.println("核心线程数:"+threadPoolTaskExecutor.getCorePoolSize());
        System.out.println("最大线程数:"+threadPoolTaskExecutor.getMaxPoolSize());
        System.out.println("线程空闲等待时间:"+threadPoolTaskExecutor.getKeepAliveSeconds());
        System.out.println("线程池内线程名称的前缀:"+threadPoolTaskExecutor.getThreadNamePrefix());
        System.out.println("当前线程池内活跃的线程数量:"+threadPoolTaskExecutor.getActiveCount());
        
    }
    @Test
    public void test2(){
        
        for(int i=0;i<100;i++){
            asyncTask.asyncTask();
        }
    }
    
    @Test
    public void testVisiable(){
        
        for (int i=0;i<100;i++){
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("testVisiable  "+Thread.currentThread().getName());
                }
            });
        }
    }
}
