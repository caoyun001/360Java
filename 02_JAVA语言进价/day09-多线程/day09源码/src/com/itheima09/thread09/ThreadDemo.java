package com.itheima.thread09;

/**
 *  JDK1.5新特性:
 *    JUC   java.util.concurrent  并发包
 *
 *    java.util.concurrent.locks包中定义接口Lock
 *    目的取代synchronized, 新的锁对象
 *
 *    学习接口: 方法,实现类
 *    lock()获取锁
 *    unlock()释放锁
 *    接口的实现类ReentrantLock,
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
