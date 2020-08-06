package com.itheima.exception09;

/**
 * 尽量: 不要在异常处理中,使用return
 *
 * 注意: finally只有一种情况下不执行
 *   finally代码之前,System.exit(0)
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        boolean b = show();
        System.out.println(b);

        System.out.println( get() );
    }

    public static int get(){
        int a = 1;
        try{
            return a;
        }catch (Exception ex){
            return a;
        }finally {
            a++;
        }
    }


    public static boolean show(){
        try{
            return false;
        }catch (Exception ex){

        }finally {
            return true;
        }
    }
}
