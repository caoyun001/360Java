package com.itheima.privilege01;

import java.util.ArrayList;

/**
 * 权限:  public    protected    default    private
 * 最常用的权限
 *   public : 任何程序都可以使用
 *   private: 只能在本类中使用
 *
 *   default:   同一个类是可以使用,同一个包中是可以使用的,其他情况不能用的
 *   protected:  受保护, 在不同包的子类中可以使用,不是一个包,又不是子类,不能使用
 *               专门给子类使用
 *   全世界所有的类都是Object的子类,为什么方法权限有pubic和protected之分
 *   protected权限用法,只能在子类中才能使用, 关键点: 子类 super才能访问,不能使用
 */
public class PrivilegeDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.eat();
    }
}
