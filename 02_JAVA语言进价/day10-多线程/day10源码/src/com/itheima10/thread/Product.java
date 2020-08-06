package com.itheima.thread;

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
        while (true) {
            //同步代码块，线程安全
            synchronized (baoZiPu) {
                //判断资源中的标志位，是否允许生产
                //flag=false生产
                if (baoZiPu.getFlag()==true){
                    //flag标志是true，不能生产，消费者还没有吃饭
                    //等，他吃完  Object类的方法wait()无限等
                    try{ baoZiPu.wait();}catch (Exception ex){ex.printStackTrace();}
                }
                baoZiPu.set();
                //生产完毕后，修改标志位=true
                baoZiPu.setFlag(true);
                //唤醒消费者线程
                baoZiPu.notify();
            }
        }
    }
}
