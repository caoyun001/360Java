package com.itheima.abstract02;

/**
 * 老师类,是员工的一种,属于员工,继承员工
 */
public class Teacher extends Employee{
    public void work() {
        System.out.println("老师讲课");
        System.out.println("老师备课");
    }
}
