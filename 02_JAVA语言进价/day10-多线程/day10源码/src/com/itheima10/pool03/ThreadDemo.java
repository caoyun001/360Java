package com.itheima.pool03;

import java.util.concurrent.*;

/**
 *  实现线程池练习
 *   1： 开启一个线程，计算高斯算法 1+2+3+....+100 = 5050
 *   2:  开启一个线程，切割字符串
 *
 *   线程执行任务，选择使用Callable接口
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        //提交任务，计算高斯
        Future<Integer> sumFuture = ex.submit( new GaoSiCallable());
        System.out.println(sumFuture.get());

       //提交任务，计算切割字符串
       Future<String[]> splitFuture =  ex.submit(new QieGeCallable());
       String[] strs = splitFuture.get();
       for(String s : strs){
           System.out.println(s);
       }
    }
}
