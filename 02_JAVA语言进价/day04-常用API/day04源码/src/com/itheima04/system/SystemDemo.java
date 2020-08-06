package com.itheima.system;

/**
 *  java.lang.System表示系统
 *  很多有用的字段(成员变量)out,in
 *  System类不能创建对象,private修饰构造方法
 *  静态调用 System.类名
 */
public class SystemDemo {
    public static void main(String[] args) {
        method_5();
    }
    /**
     *  毫秒值,测试10000次循环需要的时间
     */
    public static void method_5(){
        long start = System.currentTimeMillis();

        for(int i = 0 ; i < 10000; i++){
            System.out.println(i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * System类的方法  src
     * static void arraycopy(Object src,int srcPos, Object dest, int destPos,int length)复制数组
     * 注意: 复制的是数组中的元素
     * 参数解释:
     *   src: 要复制的源数组
     *   srcPos:源数组的开始索引
     *   dest:复制后的目标数组
     *   descPos:目标数组的开始索引
     *   length;复制的元素个数
     */
    public static void method_4(){
        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,0};
        /**
         * src数据源,2数据源的开始索引
         * desc目的数组,1目的数组的开始索引
         * 3,复制3个元素
         */
        System.arraycopy(src,2,dest,1,3);
        for(int i = 0 ; i < dest.length; i++){
            System.out.println(dest[i]);
        }

    }

    /**
     * System类的方法
     * static void gc()运行垃圾回收器,堆内存清理对象垃圾
     * 构造方法,创建对象
     * 析构函数,销毁对象
     *   Object类方法 finalize()
     *   JVM内存中收取垃圾,会自动调用方法finalize()
     *
     * JVM在内存中收取垃圾,使用的是线程技术
     */
    public static void method_3(){
        new Person();
        new Person();
        new Person();
        new Person();
        new Person();
        new Person();
        new Person();
        System.gc();
    }

    /**
     * System类的方法
     * static long currentTimeMillis()返回自1970的毫秒值
     * 方法等同于 new Date().getTime()
     * 用户程序性能测试
     */
    public static void method_2(){
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }

    /**
     * System类的方法
     * static void exit(int status)  结束JVM运行
     * 参数传递int类型,使用的时候,传递的是0
     * 正常结束JVM, 异常结束
     */
    public static void method(){
        while (true){
            System.exit(0);
            //代码,无意义
        }
    }
}
