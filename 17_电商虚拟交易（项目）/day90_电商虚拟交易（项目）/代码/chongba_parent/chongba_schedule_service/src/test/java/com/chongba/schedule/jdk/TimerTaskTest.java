package com.chongba.schedule.jdk;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 传智播客*黑马程序员.
 */
public class TimerTaskTest {

    public static void main(String[] args) {
        //创建timer
        Timer timer = new Timer();
        
        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()/1000+"执行了任务");
            }
        },1000L);
        System.out.println(System.currentTimeMillis()/1000);*/
        // 如果任务的执行时间<=当前时间,任务会立刻执行
       /* timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()/1000+"执行了任务");
            }
        },new Date(System.currentTimeMillis()-1000L));
        System.out.println(System.currentTimeMillis()/1000);*/

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()/1000+"执行了任务");
            }
        },1000L,2000L);
        System.out.println(System.currentTimeMillis()/1000);*/

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()/1000+"执行了任务");
            }
        },new Date(System.currentTimeMillis()-2000L),2000L);
        System.out.println(System.currentTimeMillis()/1000);*/
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()/1000+"执行了任务");
            }
        },new Date(System.currentTimeMillis() - 3000L),1000L);
        System.out.println(System.currentTimeMillis()/1000);
        //  2 3 4 5
    }
    
}
