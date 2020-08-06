package com.itheima.pool2;

import com.itheima.pool.MyRunnable;

import java.util.concurrent.*;

/**
 * java.util.concurrent.Callable<V>接口
 *
 *  V call() throws Exception;
 *  可以抛出异常，方法具有返回值
 *
 *  接口只能在线程池中使用
 *
 *  线程池对象 submit(  Callable接口 )提交线程任务
 *  方法的返回值是 Future接口，表示线程执行完毕后的返回值
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程池，提交任务，获取线程执行后的返回值
        ExecutorService es =  Executors.newFixedThreadPool(2);
        //接受submit方法的返回值
        Future<String> future =  es.submit(new MyCallable());
        //接口中的方法 get()获取线程的返回值
        String str = future.get();
        System.out.println(str);
    }
}
