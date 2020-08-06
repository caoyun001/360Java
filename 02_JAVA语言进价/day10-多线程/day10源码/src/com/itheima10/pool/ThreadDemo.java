package com.itheima.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JDK1.5后，提供的线程池  juc包
 * java.util.concurrent.Executors类
 * Executors 是工厂类，创建对象，用来创建线程池对象
 *
 * static ExecutorService newFixedThreadPool(int nThreads)
 * 创建线程池对象，传递参数是线程池中线程的个数，是个无界队列
 *
 * 方法的返回值： ExecutorService接口，返回的是实现类对象
 * 接口就表示线程池对象
 * ExecutorService接口方法： 提交线程执行的任务
 *   submit(Runnable接口实现类)
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //创建线程池对象，固定个数2个线程
        ExecutorService es =  Executors.newFixedThreadPool(2);
        //提交任务，submit方法（Runnable接口实现类）
        es.submit( new MyRunnable());
        es.submit( new MyRunnable());
        es.submit( new MyRunnable());
        es.shutdown();
    }
}
