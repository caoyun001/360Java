package com.chongba.schedule.jdk;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by 传智播客*黑马程序员.
 */
public class DelayedTask implements Delayed{

    private int executeTime;
    
    public DelayedTask(int delay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,delay);
        this.executeTime = (int)(calendar.getTimeInMillis()/1000);
    }
    

    /**
     * 获得任务对象在队列中的剩余时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        int delay = executeTime - (int)(System.currentTimeMillis()/1000);
        return delay;
    }

    /**
     * 用于不同的任务对象之间的排序比较
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        long l = this.getDelay(TimeUnit.SECONDS) - o.getDelay(TimeUnit.SECONDS);
        return l==0? 0 :( l < 0 ? -1:1);
    }

    public static void main(String[] args) {
        DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
        //向队列中添加任务
        queue.add(new DelayedTask(5));
        queue.add(new DelayedTask(10));
        queue.add(new DelayedTask(15));
        //消费任务
        System.out.println(System.currentTimeMillis()/1000+"开始消费任务");
        
        while (queue.size() !=0){
            DelayedTask task = queue.poll();
            if(task !=null){
                System.out.println(System.currentTimeMillis()/1000+"消费了任务");
            }
            //每隔1秒钟消费一次
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        
        
        
    }
}
