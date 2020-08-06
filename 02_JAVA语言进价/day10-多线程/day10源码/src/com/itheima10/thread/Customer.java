package com.itheima.thread;

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
        while (true) {
            //同步代码块，线程安全
            synchronized (baoZiPu) {
                //消费者线程，判断标志位，是否允许消费
                if (baoZiPu.getFlag() == false)
                    //flag是false，没有生产完，不能消费
                    //等生产完毕
                    try {
                        baoZiPu.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                baoZiPu.get();
                //消费完，修改标志位
                baoZiPu.setFlag(false);
                //唤醒生产线程
                baoZiPu.notify();
            }
        }
    }
}
