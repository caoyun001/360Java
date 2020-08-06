package com.itheima.thread05;

/**
 *  使用匿名内部类,实现线程程序
 *  1: 继承父类
 *  2: 实现接口
 *
 *  匿名内部类: 取代了实现类,或者子类
 *
 *  格式:
 *    new 父类接口(){
 *        重写父类方法();
 *    }
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //匿名内部类,取代Thread的子类
        //就是在创建他的子类对象
        new Thread(){
            public void run(){
                System.out.println("匿名内部类实现线程");
            }
        }.start();

        //匿名内部类,取代Runnable接口实现类
        Runnable r =  new Runnable(){
            public void run(){
                System.out.println("匿名内部类实现线程_接口方式");
            }
        };

        new Thread(r).start();

        //new Thread( ()-> System.out.println("启动线程") ).start();
    }
}
