package com.itheima.pool;

public class MyRunnable implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName()+ " 线程执行任务");
    }
}
