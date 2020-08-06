package com.itheima.thread04;

/**
 * 实现多线程的第二种方式: 接口实现
 *  1: 定义类实现接口 java.lang.Runnable
 *  2: 重写方法run
 *  3: 创建Thread对象
 *   Thread(Runnable target) 传递接口实现类对象
 * 4: Thread类方法start()启动线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //创建Runnable接口实现类对象/
        MyRunnable my = new MyRunnable();
        //创建Thread对象,构造方法中,传递接口实现类对象
        Thread t = new Thread(my);
        t.start();
    }
}
