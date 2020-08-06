package com.itheima.thread06;

public class Ticket implements  Runnable{
    //定义票源
    private int tickets = 100;
    private Object object = new Object();

    //在方法run()售票

    /**
     *  通过程序添加线程的休眠方法 10毫秒
     *  出现了数据的安全问题
     *
     *  同步技术保证线程安全
     *  关键字 : synchronized
     *  语法:
     *    synchronized(任意对象){
     *        线程操作的所有共享数据
     *    }
     *    同步代码块
     *    锁: 有锁的线程进入同步代码块执行,执行完毕归还锁
     *    无锁的线程,等待在同步之外
     */
    public void run(){
        while (true) {
          synchronized (object) {
                if (tickets > 0) {
                    //线程先别执行,休息一会
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                    }
                    System.out.println(Thread.currentThread().getName() + "出售第::" + tickets--);
               }
            }
        }
    }
}
