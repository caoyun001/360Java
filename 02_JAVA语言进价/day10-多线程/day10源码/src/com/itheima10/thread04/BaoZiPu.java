package com.itheima.thread04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  生存者和消费者案例
 *  改进：Lock锁和Condition接口
 */
public class BaoZiPu {
    private int count;

    private boolean flag = false;

    //创建Lock接口的实现类对象
    private Lock lock = new ReentrantLock();
    //获取出Condition接口对象，lock接口的方法 newCondition()
    private Condition product =  lock.newCondition();//线程阻塞队列，名字生产
    private Condition customer = lock.newCondition();//线程阻塞队列，名字消费

    //方法是消费线程调用
    public void get(){
        //获取锁对象
        lock.lock();
        //判断标记，如果没有包子,是false，等
        while (flag == false)
            //消费线程，等待，进入到消费的阻塞队列
            try{ customer.await();}catch (Exception ex){ex.printStackTrace();}


        System.out.println("消费第 "+count+" 个包子...");
        //修改标志位
        flag = false;
        //唤醒对方线程，在生产队列中的线程
        product.signal();
        lock.unlock();
    }

    //方法是生产线程调用
    public void set(){
        //获取锁对象
        lock.lock();
        //判断标记，如果有包子，是true，等
        while (flag == true)
            //等待，释放锁，进入阻塞队列
            try{product.await();}catch (Exception ex){ex.printStackTrace();}
        count++;
        System.out.println("生产第 "+count+" 个包子");
        //修改标志位
        flag = true;
        //唤醒对方线程
        //生产完毕结束，释放锁
        customer.signal();
        lock.unlock();
    }
}
