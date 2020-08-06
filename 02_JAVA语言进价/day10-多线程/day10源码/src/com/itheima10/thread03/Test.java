package com.itheima.thread03;

public class Test {
    public static void main(String[] args) {
        //创建资源对象，包子铺
        //资源对象，传递线程中
        BaoZiPu baoZiPu = new BaoZiPu();

        //创建生产者对象
        Product product = new Product(baoZiPu);
        Product product2 = new Product(baoZiPu);
        Product product3 = new Product(baoZiPu);
        //创建消费者对象
        Customer customer = new Customer(baoZiPu);
        Customer customer2 = new Customer(baoZiPu);
        Customer customer3 = new Customer(baoZiPu);

        //创建线程对象
        Thread productThread = new Thread(product);
        Thread productThread2 = new Thread(product2);
        Thread productThread3 = new Thread(product3);

        Thread customerThread = new Thread(customer);
        Thread customerThread2 = new Thread(customer2);
        Thread customerThread3 = new Thread(customer3);

        productThread.start();
        productThread2.start();
        productThread3.start();
        customerThread.start();
        customerThread2.start();
        customerThread3.start();
    }
}
