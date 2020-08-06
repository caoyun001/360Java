package com.itheima.thread06;

/**
 * 售票案例,引出线程的安全问题
 * 前提: 必须是多个线程,同时操作一个资源
 *
 * 电影票只有100张 (资源)
 * 3个售票窗口,同时出售 (资源共享,100张)
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //创建Runnable接口实现类对
        Ticket ticket = new Ticket();
        //创建线程对象,3个
        Thread t0 = new Thread(ticket);
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);

        t0.start();
        t1.start();
        t2.start();
    }
}
