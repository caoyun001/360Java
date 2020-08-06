package com.itheima.thread02;

/**
 * 消费者线程
 * 调用资源对象，包子铺方法get
 */
public class Customer implements Runnable {

    //创建资源对象
    private BaoZiPu baoZiPu;

    public Customer(BaoZiPu baoZiPu){
        this.baoZiPu = baoZiPu;
    }

    @Override
    public void run() {
        while (true)
            baoZiPu.get();
    }
}
