package com.itheima.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器： 在指定的时间隔内，进行操作
 * java.util.Timer 实现定时器
 * 构造方法直接new 无参数
 * 启动定时器方法：
 *                定时器任务         开始时间        毫秒间隔
 *   void schedule(TimerTask task, Date firstTime, long period)
 *   TimerTask参数，抽象类，传递子类对象，重写run()
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //开启定时器
        timer.schedule(new TimerTask(){
            public void run(){
                System.out.println("定时执行");
            }
        }, new Date(),3000);
    }
}
/*class MyTask extends TimerTask{
    public void run(){
        System.out.println("定时执行");
    }
}*/
