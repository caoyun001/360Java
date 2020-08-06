package com.itheima.big;

import java.math.BigInteger;

/**
 *  大数运算
 *    基本数据类型范围,long类型
 *    假如有数据超过long的范围
 *
 *    浮点数据,double
 *    假如有数据超过double的范围
 *
 *  Java中,超过了最大取值范围的数,不能称为数
 *  java.math.BigInteger 封装了整数中的超级大数
 *  java.math.BigDecimal 封装了浮点数中的超级大数
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        method_5();
    }
    /**
     * 两个BigInteger之间进行运算,除法
     * BigInteger类中定义方法 BigInteger divide (BigInteger big)
     * 除法后是浮点数据的时候,计算结果保留整数部分
     */
    public static void method_5(){
        BigInteger b1 = new BigInteger("12345678909876543210123");
        BigInteger b2 = new BigInteger("98765432101234567890321");
        //除法运算 b2/b1
        BigInteger b3 =  b2.divide(b1);
        System.out.println(b3);
    }

    /**
     * 两个BigInteger之间进行运算,乘法
     * BigInteger类中定义方法 BigInteger multiply (BigInteger big)
     */
    public static void method_4(){
        BigInteger b1 = new BigInteger("12345678909876543210123");
        BigInteger b2 = new BigInteger("98765432101234567890321");
        //乘法运算 b1*b2
        BigInteger b3 = b1.multiply(b2);
        System.out.println(b3);
    }

    /**
     * 两个BigInteger之间进行运算,减法
     * BigInteger类中定义方法 BigInteger subtract (BigInteger big)
     */
    public static void method_3(){
        BigInteger b1 = new BigInteger("12345678909876543210123");
        BigInteger b2 = new BigInteger("98765432101234567890321");
        //减法运算 b1-b2
        BigInteger b3 =  b1.subtract(b2);
        System.out.println(b3);
    }

    /**
     * 运算: + - * /
     * 两个BigInteger之间进行运算
     * 加法运算符: BigInteger类中定义方法 BigInteger add (BigInteger big)
     */
    public static void method_2(){
        BigInteger b1 = new BigInteger("12345678909876543210123");
        BigInteger b2 = new BigInteger("98765432101234567890321");
        //超级大数,进行求和运算
        BigInteger b3 =  b1.add(b2);
        System.out.println(b3);
    }

    /**
     * BigInteger构造方法,
     * BigInteger(String str)传递字符串,必须是数字格式
     * 数字格式的字符串,变成BigInteger对象,字符串理论上可以无限
     */
    public static void method(){
        BigInteger big = new BigInteger("456754321345678976543214789654321456754321456843298765432");
        System.out.println(big);
    }
}
