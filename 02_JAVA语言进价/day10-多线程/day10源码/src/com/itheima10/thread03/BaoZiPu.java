package com.itheima.thread03;

/**
 * 资源对象，包子
 * 被线程调用的
 *
 *
 *  flag =false 指示灯，标记
 *  指示线程，该做什么
 *  默认值false ， 没有包子，需要生产线程进行生产，对变量count++
 *  生产线程，完成任务， 修改标志位= true (有包子)，唤醒对方线程。
 *
 *  flag=true 指示线程，有包子，需要消费者线程进来消费，对变量输出打印
 *  消费已经完成，修改标志位 = false(无包子)，唤醒对方线程。
 */
public class BaoZiPu {
    private int count;

    //定义布尔变量，标志位
    private boolean flag =false ;

    //方法get,消费方法，消费线程调用变量，输出
    public synchronized void get(){
        //线程，即使被唤醒，不能立刻执行，判断标志位
        while (flag == false){
            //无包子，等待
            try{this.wait();}catch (Exception ex){ex.printStackTrace();}
        }
        System.out.println("消费第 "+count+" 个包子...");
        //修改标志位，改成没有包子
        flag = false;
        this.notifyAll();
    }


    //方法set，生产方法，生产线程调用变量++
    public synchronized void set(){
       //线程，即使被唤醒，不能立刻执行，判断标志位
        while ( flag == true){
            //有包子，等待
           try{this.wait();}catch (Exception ex){ex.printStackTrace();}
        }
        count++;
        System.out.println("生产第 "+count+" 个包子");
        //修改标志位,改成有包子
        flag = true;
        this.notifyAll();
    }

}
