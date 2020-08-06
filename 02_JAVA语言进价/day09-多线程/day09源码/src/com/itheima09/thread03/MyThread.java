package com.itheima.thread03;

public class MyThread extends Thread {
    public void run(){
        Thread t = Thread.currentThread();//当前线程,就是Thread-0
        System.out.println( "线程名字::"+t.getName());
    }
}
