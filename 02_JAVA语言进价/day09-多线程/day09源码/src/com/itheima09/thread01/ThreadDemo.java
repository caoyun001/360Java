package com.itheima.thread01;

/**
 *  线程: 也是对象
 *  java.lang.Thread类,描述了线程对象
 *  实现多线程程序的方式一:
 *    1: 定义类继承Thread
 *    2: 重写方法run
 *    3: 创建子类对象
 *    4: 子类对象调用方法 start()
 *      线程执行,JVM调用run()
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //3: 创建子类对象
        while (true) {
            MyThread myThread = new MyThread();
            //4: 子类对象调用方法 start()
            myThread.start();
        }

      /*  for(int i = 0 ; i < 500 ; i++) {
            System.out.println("main方法..."+i);
        }*/
    }
}
