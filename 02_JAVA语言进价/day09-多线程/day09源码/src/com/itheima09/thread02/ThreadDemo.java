package com.itheima.thread02;

/**
 * 问题:
 *   1: 为什么要继承Thread  (一切是对象)
 *     Thread是线程对象,继承Thread,子类也是线程对象
 *
 *   2: 为什么重写run
 *     每个程序人员,用线程运行什么程序,未知的
 *     线程做秒杀,线程游戏,测试
 *     线程建对象,线程做循环
 *     规定模版,run()方法,无论用线程做什么,代码写run中
 *     JVM就调run
 *
 *   3: 启动线程为什么调用start,而不是run
 *     线程中: 被CPU执行,Java技术实现线程依赖本机操作系统
 *     要和操作系统交互了
 *     start()方法,内部调用另一个方法 start0()
 *     private native void start0(); 操作系统交互,启动线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
