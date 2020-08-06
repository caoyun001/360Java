package com.itheima.thread04;

public class Product implements  Runnable {

    private BaoZiPu baoZiPu ;

    public Product(BaoZiPu baoZiPu) {
        this.baoZiPu = baoZiPu;
    }

    @Override
    public void run() {
        while (true)
            baoZiPu.set();
    }
}
