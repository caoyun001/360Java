package com.itheima.modify;

/**
 * 修饰符: 非法的修饰符组合
 * 修饰符有冲突,不能放在一起
 * 权限,静态,最终,抽象
 *
 * abstract和final : 抽象是为了让子类重写,final不可重写
 * abstract和private : 抽象是为了让子类重写,private只有本类使用,子类根本继承不了
 * abstract和static : 抽象类没有方法体,静态是类名.方法调用
 *
 * 方法重写的时候,子类方法的权限必须大于或者等于父类权限
 */
public abstract class ModifyDemo {

    public  abstract  void eat();
}

class Modify extends ModifyDemo{
    public void eat(){

    }
}
