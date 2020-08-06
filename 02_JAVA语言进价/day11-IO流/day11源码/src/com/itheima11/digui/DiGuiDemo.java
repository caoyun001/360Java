package com.itheima.digui;

/**
 * 方法的递归调用: 编写程序上一个手段
 * 方法自己调用自己,具有方法语言,都可以使用递归
 * 解决问题:
 *   目录遍历案例,功能是确定的,就是制定目录进行遍历
 *   遍历的目录,每次可能不同
 *
 *   功能的计算主体明确,计算中的参数每次是变化
 *
 *   方法自身调用注意事项:
 *     1: 不能是死递归,方法不停的进栈,不会出去,内存满了,溢出
 *     2: 递归一定要有出口,能结束.但是如果进栈的方法过多也不可以
 *
 *     斐波那契 1 1 2 3 5 8 13 21 34  144
 */
public class DiGuiDemo {
    public static void main(String[] args) {
        int a =  getJieCheng(10);
        System.out.println(a);

        System.out.println(getTuZi(20));
    }

    public static int getTuZi(int month){
        if( month == 1)
            return 1;
        if( month == 2)
            return 1;
        return  getTuZi(month-1)+getTuZi(month-2);
    }

    /**
     * 递归实现阶乘运算
     * 5!  1*2*3*4*5
     * 计算规律:
     *    几的阶乘,不一定, 未知的
     *    num = 5
     *    5 * (5-1)
     *
     *    5 * (5-1) * (5-1的结果-1)
     *
     *    出口 (5-1-1-1...) = 1 结束计算
     */
    public static int getJieCheng(int num){
        if( num == 1)
            return 1;
       return num * getJieCheng(num -1) ;
    }

}
