package com.chongba.schedule;

import com.chongba.entity.Task;
import com.chongba.schedule.inf.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        taskService.cancelTask(1181523745920094209L);
    }
    
}
