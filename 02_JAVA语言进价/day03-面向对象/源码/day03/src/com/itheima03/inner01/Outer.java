package com.itheima.inner01;

/**
 * 定义外部类,类名Outer
 * 内部类编译后有class文件吗
 *
 * 外部类名$内部类名
 */
public class Outer {
    private int a = 1;
    //类的成员位置上,定义内部类
    //Inner就是Outer的内部类
    class Inner{
        public void inner(){
            System.out.println("内部类方法");
            System.out.println(a);
        }
    }
}
