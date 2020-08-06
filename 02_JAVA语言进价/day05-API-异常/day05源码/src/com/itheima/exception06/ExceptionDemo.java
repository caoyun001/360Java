package com.itheima.exception06;

/**
 *  需求:
 *    定义方法,计算正方形面积 (整数)
 *
 *  throw: 在方法内部抛出异常对象
 *    只能写在方法里面,throw new 异常对象()
 *
 *  throws: 在方法定义上使用,告知调用者有异常
 *    throws只能写在方法定义后,throws 写异常类名
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int area = getArea(5);
            System.out.println("面积是:" + area);
        }catch (Exception ex){
            System.out.println("边长不存在");
        }
    }
    /**
     *  边长未知数,定义在参数上
     *  用户调用方法时,传递
     *  用户传递0或者负数
     *  使用异常技术,手动抛出异常
     *  关键字 throw new的异常对象()
     *
     *  getArea()方法: 传递错误的参数,导致不能计算
     *  方法的内部会抛出异常的对象, 对于调用者main,看的到你方法中有异常吗,NO
     *  getArea()方法,告诉调用者,我有异常!!
     *
     *  关键字 throws  在方法的定义上标明出,我有异常,需要调用者进行处理
     *  throws关键字后面写异常类的名字
     */
    public static int getArea(int a)throws Exception{
        if(a <= 0)
            //无法计算,使用异常提示用户,手动抛出异常
            throw new Exception();
        return  a * a;
    }
}
