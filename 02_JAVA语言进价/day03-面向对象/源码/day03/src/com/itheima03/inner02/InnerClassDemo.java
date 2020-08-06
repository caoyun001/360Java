package com.itheima.inner02;

public class InnerClassDemo {
    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.inner();
    }
}
