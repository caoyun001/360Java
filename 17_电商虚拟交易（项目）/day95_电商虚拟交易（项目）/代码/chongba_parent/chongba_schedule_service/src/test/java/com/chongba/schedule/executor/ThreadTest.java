package com.chongba.schedule.executor;

/**
 * Created by 传智播客*黑马程序员.
 */
public class ThreadTest {

    public static void main(String[] args) {
        
        //继承Thread
        MyThread myThread1 = new MyThread();
        myThread1.setName("myThread1_");
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread2_");
        myThread2.start();
        
        //实现Runnable
        MyRunnable myRunnable1 = new MyRunnable();
        Thread thread1 = new Thread(myRunnable1);
        thread1.setName("myRunnable1_");
        thread1.start();

        Thread thread2 = new Thread(myRunnable1);
        thread2.setName("myRunnable2_");
        thread2.start();
        System.out.println(Thread.currentThread().getName()+"_"+System.currentTimeMillis());
    }
}
class MyThread extends  Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+System.currentTimeMillis());
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+System.currentTimeMillis());
    }
}