package com.itheima.array;

/**
 * 数组的二分搜索法
 * 数组的搜索:
 *   在一个数组中,查找一个元素是否出现在数组中
 *   如果有,返回出现的索引
 *   如果没有,返回负数
 */
public class ArrayDemo02 {
    public static void main(String[] args) {
        /*int[] arr = {3,1,5,9,12,8,10};
        int index = search(arr,15);
        System.out.println(index);*/

        int[] arr = {1,5,9,12,17,20,22,25};
        int index = binarySearch(arr,18);
        System.out.println(index);
    }
    /**
     * 创建方法,传递数组
     * 传递要查找元素
     * 使用数组的二分搜索法,提高效率
     * 前提: 数组中的元素必须是有序的 (升序,降序都可以)
     */
    public static int binarySearch(int[] arr, int key){
        //定义变量,保存数组最小索引
        int min = 0;
        //定义变量,保存数组最大索引
        int max = arr.length - 1;
        //定义变量,保存数组折半后的中间索引
        int mid = 0;
        //循环折半
        //最小索引 <= 最大索引,才能折半
        while (min <= max){
            //折半
            mid = (min + max) / 2;
            //中间索引上的元素,和关键字词,比较
            if(arr[mid] < key){
                //最小索引=中间索引+1
                min = mid + 1;
            }
            //中间索引上的元素和关键词比较
            else if(arr[mid] > key){
                //最大索引=中间索引-1
                max = mid - 1;
            }
            //找到了,相等
            else{
                //返回索引
                return mid;
            }
        }
        //循环外面,折半完成,依然找不到元素,返回负数
        return -1;
    }


    /**
     * 创建方法,传递数组
     * 传递要查找元素
     * 分析:效率低
     *   假如被查找的元素没有!
     *   所有的元素全部遍历出来了
     */
    public static int search(int[] arr, int key){
        //遍历数组,key和每个元素比较
        for(int i = 0 ;i < arr.length; i++){
            if(arr[i] == key)
                return i;
        }
        return -1;
    }
}
