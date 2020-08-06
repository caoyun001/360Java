package com.itheima.extends03;

public class Zi extends Fu {
    int a = 2;
    public void show(){
        int a = 3;
        System.out.println(a);// 3
        System.out.println(this.a);// 2
        System.out.println(super.a);// 1
    }
}
