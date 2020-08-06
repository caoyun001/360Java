package com.itheima.thread01;

public class MyThread extends Thread {
    public void run(){
        for(int i = 0 ; i < 500 ; i++) {
            System.out.println("重写run方法..."+i);
        }
    }
}
