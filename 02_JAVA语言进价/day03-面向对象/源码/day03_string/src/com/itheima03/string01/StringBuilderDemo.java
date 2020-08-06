package com.itheima.string01;

/**
 * StringBuilder称为字符串缓冲区
 * 缓冲区:提高效率
 * StringBuilder可变字符序列
 *   内部字符数组 没有final char[] value
 *   可变数组 (数组是固定长度),默认长度16
 *   new StringBuilder()
 *
 * String不可变字符序列
 *   内部字符数组 final char[] value
 *
 *
 *  StringBuffer和StringBuilder的使用完完全全一样
 *  区别:StringBuilder线程不安全运行速度快,StringBuffer线程安全运行速度慢
 *
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("asdasdas").append("SDfdsfdsfsd").append("DSFsdfdsf");
        System.out.println(sb);

        String str = "a"+"b"+"c";
        System.out.println(str);
    }
}
