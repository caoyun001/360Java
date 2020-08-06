package com.itheima.thread07;

/**
 * private void pay() 方法中的所有代码
 * 都是线程操作的共享数据,不使用同步代码块
 * 同步整个方法:方法修饰符上,使用同步关键字
 *
 * 问题:
 *   同步方法中,有对象锁吗,必须有锁
 *   锁是对象,当前对象引用 this
 *
 *   如果方法是静态的,同步中有锁吗
 *   静态方法中,同步锁,不是this
 *
 *   时间差: 静态修饰成员,优先于非静态的成员存在
 *
 *   程序运行需要编译后的文件class
 *   class文件也是对象
 *   静态方法同步中的对,是class文件这个对象
 *
 *   class文件这个对象只能获取,不能创建
 *   固定写法 类名.class  (反射)
 *
 */
public class Ticket implements  Runnable{
    //定义票源
    private static int tickets = 100;
    //private Object object = new Object();
    public void run(){
        while (true) {
            pay();
        }
    }

    //定义方法,实现售票,run()调用
    private static  void pay(){
        synchronized (Ticket.class) {
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
