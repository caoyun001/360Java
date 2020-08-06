package com.itheima.abstract04;

/**
 * 定义员工类,定义的是所有员工的共性内容
 * 工号和姓名
 * 工作方法
 */
public abstract class Employee {
    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void work();
}
