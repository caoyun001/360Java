package com.itheima.abstract02;

public class AbstractDemo {
    public static void main(String[] args) {
        //创建子类对象
        Teacher teacher = new Teacher();
        teacher.work();

        Manager manager = new Manager();
        manager.work();
    }
}
