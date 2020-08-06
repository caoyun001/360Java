package com.itheima.enums;

/**
 * 引用数据类型,枚举
 * 和接口,类,注解,同一个级别上引用类型
 * 枚举常量
 * 定义枚举关键字 enum
 *
 * 枚举的应用:
 *   订单的状态:
 *      订单提交:  没付钱
 *      订单提交:  已付钱(等待发货)
 *      订单提交:  发货
 *      订单提交:  确认收获(钱到)
 *      订单提交:  评价
 *      订单提交:  退货
 *      订单提交:  失效
 */
public class EnumDemo {
    //调用枚举中的常量 ,静态
    public static void main(String[] args) {

        Color c = Color.RED;
        System.out.println(c.toString());
        System.out.println(c.getName());

        c = Color.GREEN;
        System.out.println(c);
    }
}














