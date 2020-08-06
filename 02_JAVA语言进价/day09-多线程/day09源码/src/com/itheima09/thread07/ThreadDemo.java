package com.itheima.thread07;
/**
 *  优化:
 *    线程售票动作,抽取到一个方法中
 *    run()调用
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
