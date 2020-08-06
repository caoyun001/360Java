package com.itheima.exception04;

/**
 *  try...catch用法
 *  多catch并行
 *  try{
 *
 *  }catch(){
 *
 *  }catch(){
 *
 *  }
 *
 *  多个catch并行: (异常类的类名),先后顺序
 *  异常类之间没有继承关系的时候,平级异常,没有顺序
 *  如果异常类之间有继承关系的时候,父类异常写在下面
 *
 *   Exception
 *     |-- RuntimeException
 *       |-- NullPointerException
 *       |-- IndexOutOfBoundsException
 *          |-- ArrayIndexOutOfBoundsException
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            show(0);
        }catch (NullPointerException ex){
            System.out.println("处理空指针");
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("处理数组越界");
        }
    }
    /**
     * 需求,定义方法
     * 造异常, 创建数组越界异常,创建空指针异常
     */
    public static void show(int a){
        if(a == 0){
            int[] arr = new int[0];
            System.out.println(arr[1]);
        }else {
            int[] arr = null;
            System.out.println(arr.length);
        }
    }
}
