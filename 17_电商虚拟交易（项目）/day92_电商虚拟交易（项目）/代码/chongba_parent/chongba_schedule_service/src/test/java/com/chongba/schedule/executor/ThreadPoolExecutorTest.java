package com.chongba.schedule.executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by 传智播客*黑马程序员.
 */
public class ThreadPoolExecutorTest {
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
       
        
        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                100,5, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        
        //向线程池中提交100个任务
       /* for(int i=0;i<100;i++){
            threadPoolExecutor.execute(new MyRunnableTask(i));
        }*/

       /* Future<String> future = threadPoolExecutor.submit(new MyCallableTask("黑马程序员"));
        String result = future.get(5,TimeUnit.SECONDS);
        System.out.println(result);*/
       
       //批量的提交任务并且返回任务的执行结果
        List<MyCallableTask> callableTasks = new ArrayList<>();
        for(int i=0;i<100;i++){
            callableTasks.add(new MyCallableTask("黑马程序员"+i));
        }
        List<Future<String>> futureList = threadPoolExecutor.invokeAll(callableTasks);
        for (Future<String> stringFuture : futureList) {
            String results = stringFuture.get();
            System.out.println(results);
        }

    }
}
class MyRunnableTask implements Runnable{

    private int taskNo;

    public MyRunnableTask(int taskNo){
        this.taskNo = taskNo;
    }
    @Override
    public void run() {
        System.out.println("execte MyRunnableTask "+taskNo+"----"+Thread.currentThread().getName());
    }
}
class MyCallableTask implements Callable<String>{

    private String name;
    
    public MyCallableTask(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        System.out.println("execte MyCallableTask "+name+"----"+Thread.currentThread().getName());
        return "你好！"+name;
    }
}