package com.itheima.lambda;

/**
 *  线程程序,分析问题
 *    实现线程的程序,必须在Thread类的构造方法中,传递Runnable接口实现类
 *
 *    传递参数,不得意去实现了接口Runnable,重写方法run()
 *
 *    匿名内部类: new接口(){ 重写方法run()  }
 *
 *    面向对象的束缚
 *
 *    run方法才是关键所在
 *    核心: run()方法的方法体中的代码
 *
 *    JDK8新特性 lambda 摆脱面向对象的语法束缚 (语法糖)
 *    关键方法上,方法体
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Thread thread = new Thread( new MyRunnable() );
        thread.start();

            Thread thread2 = new Thread(  new Runnable(){
                public void run(){
                    System.out.println("匿名内部类");
                }
        } );
        thread2.start();

        Thread thread3 = new Thread( ()->System.out.println("Lambda")  );
        thread3.start();

    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("线程开启");
    }
}
