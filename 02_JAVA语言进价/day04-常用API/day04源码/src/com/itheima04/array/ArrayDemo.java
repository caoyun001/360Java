package com.itheima.array;

/**
 * 数组的操作:
 *   定义
 *   遍历
 *   最大值
 *   翻转,最远端的元素换位置
 *   数组的排序   升序 1 2 3
 *     (冒泡,选择,希尔,插入,快速)
 *   数组的二分搜索法
 *      在一个数组中,找指定的元素
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {1,5,2,4,0,7,9,8,-2};
        bubbleSort(arr);
        for(int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    /**
     * 定义方法,实现数组的冒泡排序
     * 被排序的数组,传递参数
     *
     * 外循环-1,比较次数
     * 内循环-i 每次内循环次数减少
     * 内循环-1 防止数组的越界异常
     */
    public static void bubbleSort(int[] arr){
        //嵌套循环方式,实现数组的排序
        //外,控制比较多少轮,数组的长度-1
        for(int i = 0 ; i < arr.length -1; i++){
            //内,控制每轮比较的次数,每次内循环递减1
            //j=0  j<4-0-1  0 1 2
            for(int j = 0 ; j <arr.length - i - 1; j++){
                //比较换位置
                if(arr[j] > arr[j+1]){
                    //临时变量,保存数组的元素
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
