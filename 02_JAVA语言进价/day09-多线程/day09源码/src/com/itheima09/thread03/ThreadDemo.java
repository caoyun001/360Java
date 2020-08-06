package com.itheima.thread03;

/**
 * 获取线程的名字
 *
 * 每个线程都有名字,
 * 默认的是Thread-0,Thread-1
 * Thread类有方法
 *   String getName()获取线程名
 *
 *  Thread类静态方法
 *    static Thread currentThread() 返回正在执行的线程对象,当前线程对象
 *    方法写在哪里,哪里就是当前线程
 */
public class ThreadDemo  {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
       // myThread.setName("旺财");
        myThread.start();

        Thread t = Thread.currentThread();//当前正在执行的线程,主线程
        System.out.println(t.getName());

    }
}
