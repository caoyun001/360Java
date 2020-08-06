package com.itheima.thread04;

public class Customer implements Runnable {

    private BaoZiPu baoZiPu;

    public Customer(BaoZiPu baoZiPu) {
        this.baoZiPu = baoZiPu;
    }

    @Override
    public void run() {
        while (true)
            baoZiPu.get();
    }
}
