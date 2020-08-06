package com.itheima.thread09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int tickets = 100;

    private Lock lock = new ReentrantLock();
    public void run() {
        while (true){
          // synchronized (this) {
            lock.lock();
               if (tickets > 0) {
                   //线程休眠
                   try {
                       Thread.sleep(10);
                   } catch (Exception ex) {
                   }
                   System.out.println(Thread.currentThread().getName() + " 出售第::" + tickets--);
               }
          // }
            lock.unlock();
        }
    }
}
