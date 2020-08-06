package com.itheima.thread03;

/**
 * 生产者线程
 * 调用包子铺资源对象的方法set
 *
 * java.lang.IllegalMonitorStateException 无效的监视器状态异常
 * 同步（对象） 锁对象，专业名词是监视器
 * 线程通信的方法 wait(), notify() 必须依赖锁对象调用！！
 * 不是锁对象调用，抛出异常
 */
public class Product implements Runnable{
    //创建资源对象
    private BaoZiPu baoZiPu ;

    public Product(BaoZiPu baoZiPu){
        this.baoZiPu = baoZiPu;
    }

    public void run() {
        while (true)
           baoZiPu.set();
    }
}
