package com.itheima.big;

import java.math.BigDecimal;

/**
 * java.math.BigDecimal类
 * 实现高精度的浮点数运算
 * 构造方法,BigDecimal(String str )
 * 浮点的计算 + - *  和整数BigInteger基本一致,不需要重复
 *
 * 数据出现循环小数,不能给出结果,要的是高精度
 *
 * divide(BigDecimal big, int scalar,int round)
 * big:除数
 * scalar:保留的位数
 * round:怎么保留
 *
 * 1.97 5347661188369
 * 向上进1   BigDecimal.ROUND_UP
 * 直接舍去  BigDecimal.ROUND_DOWN
 * 四舍五入  BigDecimal.ROUND_HALF_UP
 * BigDecimal定义静态成员变量,表示取舍方式
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("3.125");
        BigDecimal b2 = new BigDecimal("1.582");

        //除法计算 b1/b2 divide
        //保留结果中的2位小数
        BigDecimal b3 =  b1.divide(b2,3,BigDecimal.ROUND_HALF_UP);
        System.out.println(b3);
    }
}
