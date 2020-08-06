package com.itheima.thread;

public class Test {
    public static void main(String[] args) {
        //创建资源对象，包子铺
        //资源对象，传递线程中
        BaoZiPu baoZiPu = new BaoZiPu();

        //创建生产者对象
        Product product = new Product(baoZiPu);
        //创建消费者对象
        Customer customer = new Customer(baoZiPu);

        //创建线程对象
        Thread productThread = new Thread(product);
        Thread customerThread = new Thread(customer);

        productThread.start();
        customerThread.start();
    }
}
