package com.itheima.integer;

/**
 * Integer类的功能
 *   int数据类型的最大取值范围,固定的
 *   public static final MAX_VALUE  最大取值范围
 *   public static final MIN_VALUE  最小取值范围
 *
 *   转进制的方法:
 *    public static String toBinaryString(int 十进制)转成二进制
 *    public static String toOctalString(int 十进制)转成八进制
 *    public static String toHexString(int 十进制)转成十六进制
 *
 *
 *   int intValue()需要Integer对象调用
 *   将Integer构造方法中的字符串转成int类型
 *
 */
public class IntegerDemo02 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Integer.toBinaryString(19));
        System.out.println(Integer.toOctalString(19));
        System.out.println(Integer.toHexString(15));

        Integer integer = new Integer("123");
        //构造方法中的字符串,转成int类型
        int i =  integer.intValue();
        System.out.println(i+1);
    }
}
