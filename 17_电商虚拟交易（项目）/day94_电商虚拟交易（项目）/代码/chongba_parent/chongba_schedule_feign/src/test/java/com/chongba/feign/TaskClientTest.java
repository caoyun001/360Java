package com.chongba.feign;

import com.chongba.entity.ResponseMessage;
import com.chongba.entity.Task;
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
@SpringBootTest(classes = FeignAppliction.class)
public class TaskClientTest {
    
    @Autowired
    private TaskServiceClient taskServiceClient;


    @Test
    public void test1(){
        for (int i = 0; i < 4; i++) {
            Task task  = new Task();
            task.setTaskType(2003);
            task.setParameters("testFeignClient".getBytes());
            task.setPriority(100);
            task.setExecuteTime(new Date().getTime());
            ResponseMessage reponse = taskServiceClient.push(task);
            System.out.println(reponse);
        }
    }
    @Test
    public void test2(){
        ResponseMessage message = taskServiceClient.poll(2003, 100);
        System.out.println(message);
    }

    @Test
    public void test3(){
        taskServiceClient.cancel(1185079583297368065L);// 从数据库或缓存中查找一个任务id
    }
    
    
}
