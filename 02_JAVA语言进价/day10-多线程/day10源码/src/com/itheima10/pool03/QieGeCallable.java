package com.itheima.pool03;

import java.util.concurrent.Callable;

public class QieGeCallable implements Callable<String[]> {
    public String[] call(){
        String str = "aa bbb      ccc  ddd  eeeee   f";
        return str.split(" +");
    }
}
