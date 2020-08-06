package com.itheima.box;

/**
 * 自动装箱和拆箱,是编译原理
 */
public class BoxDemo02 {
    public static void main(String[] args) {
        method_2();
    }

    public static void method_2(){
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        System.out.println(a == b);// == 引用数据类型,比较地址, false
        System.out.println(a.equals(b));// 重写方法equals,比较的是对象中的数据,true

        Integer aa = 200;
        Integer bb = 200;
        System.out.println(aa == bb);//== 引用数据类型,比较地址, false
        System.out.println(aa.equals(bb)); // 重写方法equals,比较的是对象中的数据,true

        Integer aaa = 100; // byte字节
        Integer bbb = 100; // byte字节, 不会new 对象()
        System.out.println(aaa==bbb);//== 引用数据类型,比较地址, true
        System.out.println(aaa.equals(bbb));//== 引用数据类型,比较地址, true

    }

    public static void method(){
        /**
         * javac进行编译上的优化
         * 编译为: Integer integer = Integer.valueOf(10); 最终new Integer()
         */
        Integer integer = 10;
        /**
         * javac编译器优化
         * 编译器: Integer.valueOf(  integer.intValue()+10)
         */
        integer = integer + 10;

        Integer i = null;
        if(i != null) {
            i = i + 1; //i.intValue()
            System.out.println(i);
        }
    }
}
