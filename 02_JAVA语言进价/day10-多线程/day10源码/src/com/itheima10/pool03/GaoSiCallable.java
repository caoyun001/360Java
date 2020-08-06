package com.itheima.pool03;

import java.util.concurrent.Callable;

public class GaoSiCallable implements Callable<Integer> {
    public Integer call()throws Exception{
        int sum = 0;
        for(int i = 1; i <= 100 ;i++){
            sum = sum+i;
        }
        return sum;
    }
}
