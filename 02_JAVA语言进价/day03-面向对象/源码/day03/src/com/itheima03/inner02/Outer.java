package com.itheima.inner02;

public class Outer {

    int a = 3;

    class Inner {
        int a = 2;
        public void inner(){
            int a = 1;
            System.out.println(a);//就近原则
            //a=2 是内部类Inner的成员变量
            System.out.println(this.a);//输出2

            //a=3是外部类的成员变量
            //Outer.this
            System.out.println(Outer.this.a);//输出3
        }
    }
}
