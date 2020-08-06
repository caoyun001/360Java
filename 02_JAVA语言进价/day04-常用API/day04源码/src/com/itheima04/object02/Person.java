package com.itheima.object02;

public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写父类Object的方法toString()
     * 要求返回字符串
     * toString()价值: 返回类中的成员变量值
     */
    public String toString(){
        return  "Person "+name+"..."+age;
    }

    /**
     *  重写方法equals,建立Person自己的比较内容
     *  比较对象的年龄值
     */
    public boolean equals(Object obj) {
        //判断,如果传递参数是null,不用比较
        if (obj == null)
            return false;
        //判断调用者this,和参数obj是不是一个对象
        //利用内存地址
        if(this == obj)
            return true;
        //判断,obj是不是Person对象,是才能强转
        if (obj instanceof Person) {
            //obj强制转成子类Person
            Person person = (Person) obj;
            return this.age == person.age;
        }
        return false;
    }
}
