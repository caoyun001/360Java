package com.itheima.lom;

import lombok.*;

/**
 * lombok 第三方jar包中 一些注解使用
 *
 * @Getter
 * @Setter
 * 生成 get/set方法
 * 使用,写在类上,所有的成员变量,都生效
 * 如果写在成员变量上,只有这个变量可以使用
 *
 * @AllArgsConstructor 生成满参数构造方法
 *
 * @NoArgsConstructor 生成无参数构造方法
 *
 * @ToString 生成toString()
 *
 * @EqualsAndHashCode 生成hashCode()和equals()方法
 *
 * @Data注解 = @Getter  @Setter @NoArgsConstructor  @ToString @EqualsAndHashCode
 *
 *
 *  编译原理,安装插件
 *  使用注解,插件帮助写出这些方法
 */
@Data
public class Person {
    private String name;
    private int age;
    private String address;

}
