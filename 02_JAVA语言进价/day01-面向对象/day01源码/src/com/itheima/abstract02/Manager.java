package com.itheima.abstract02;

/**
 * 班主任类: 属于员工一种
 */
public class Manager extends Employee{
    public void work() {
        System.out.println("管理考勤");
        System.out.println("管理卫生");
    }
}
