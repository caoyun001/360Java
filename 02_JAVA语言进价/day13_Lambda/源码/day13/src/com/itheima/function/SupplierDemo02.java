package com.itheima.function;

import java.util.function.Supplier;

/**
 * 函数式接口Supplier,实现数组最大值获取
 */
public class SupplierDemo02 {
    public static void main(String[] args) {
        int[] arr = {1,4,5,2,6,8,0};

        int arrayMax = getArrayMax( ()->{
            int max = arr[0];
              for(int i = 0 ; i < arr.length;i++){
                  if(arr[i]> max)
                      max = arr[i];
              }
              return max;
        } );
        System.out.println(arrayMax);
    }

    public static int getArrayMax(Supplier<Integer> supplier){
        return supplier.get();
    }
}
