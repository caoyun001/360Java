package com.chongba.schedule;

import com.chongba.entity.Task;
import com.chongba.schedule.inf.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by 传智播客*黑马程序员.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
public class TaskServiceTest {
    
    @Autowired
    private TaskService taskService;
    
    @Test
    public void testAdd(){
        Task task = new Task();
        task.setTaskType(3333);
        task.setPriority(250);
        task.setParameters("taskServcieTest".getBytes());
        task.setExecuteTime(System.currentTimeMillis());
        long taskId = taskService.addTask(task);
        System.out.println("添加完成的任务id:"+taskId);
    }
    @Test
    public void testCancel(){
        taskService.cancelTask(1182220694205763585L);
    }
    
    @Test
    public void testPollTask(){
        // 添加任务数据
        Date now = new Date();

        for(int i=0;i<3;i++){
            Task task = new Task();
            task.setTaskType(250);
            task.setPriority(250);
            task.setExecuteTime(now.getTime() + 5000 * i);
            task.setParameters("testpooltask".getBytes());
            taskService.addTask(task);
        }
        
        
        //消费
        while (taskService.size(250,250) > 0){
            Task task = taskService.poll(250,250);
            if(task != null){
                System.out.println("消费了任务:"+task);
            }
            //每隔1秒钟拉取一次
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }


    @Test
    public void testSyncDate(){

        for(int i=1;i<=3;i++){
            Task task = new Task();
            task.setTaskType(250);
            task.setPriority(250);
            task.setExecuteTime(new Date().getTime() + 5000 * i);
            task.setParameters("testpooltask".getBytes());
            taskService.addTask(task);
        }
    }
}
