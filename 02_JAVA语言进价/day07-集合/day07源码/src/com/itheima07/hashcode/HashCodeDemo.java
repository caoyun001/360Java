package com.itheima.hashcode;

/**
 * 对象的哈希值
 *
 * java.lang.Object类定义方法 hashCode();
 *
 * int hashCode() 返回该对象的哈希值  是本地方法native
 *
 * //com.itheima.hashcode.Student@1b6d3586 十六进制
 * //460141958 十进制
 *
 * 现在开始: 改口,对象的哈希值
 *
 * 内存的地址和哈希值,无关
 *
 * 哈希值: JVM赋予对象的一个整数,仅此而已
 *     //460141958
 *
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        //创建Student对象,调用方法hashCode()
        Student stu = new Student();
        int code = stu.hashCode();
        System.out.println("code=="+code);//460141958
        System.out.println(stu.toString());//com.itheima.hashcode.Student@1b6d3586
    }
}
