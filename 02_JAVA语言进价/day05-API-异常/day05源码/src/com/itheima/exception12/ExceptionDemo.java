package com.itheima.exception12;

/**
 * 子类父类的异常问题
 * 子类继承父类,重写父类的方法
 *
 * A:
 *   父类的方法show,抛出了异常,
 *   子类重写方法show,子类可以抛出异常,也可以不抛出异常
 *   但是子类抛出的异常,不能大于父类抛出的异常
 *   父亲很坏,孩子不能比父亲更坏
 *
 * B: 父类的方法show,不抛出异常
 *    子类就不能跑
 *    但是: 如果子类调用了一个抛出异常的方法
 *    子类: 无可选择,只能try...catch
 *
 *   子类方法重写,保持和父类一致性
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        Fu fu = new Zi();
        fu.show();
    }
}
