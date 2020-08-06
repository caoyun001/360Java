package com.chongba.schedule;

import com.chongba.schedule.mapper.TaskInfoLogsMapper;
import com.chongba.schedule.pojo.TaskInfoLogsEntity;
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
public class TaskInfoLogsMapperTest {
    
    @Autowired
    private TaskInfoLogsMapper logsMapper;
    
    
    @Test
    public void test(){

        TaskInfoLogsEntity logsEntity = new TaskInfoLogsEntity();

        logsEntity.setTaskType(2000);
        logsEntity.setExecuteTime(new Date());
        logsEntity.setPriority(100);
        logsEntity.setParameters("logs".getBytes());
        logsEntity.setVersion(1);
        logsEntity.setStatus(0);

        logsMapper.insert(logsEntity);

        TaskInfoLogsEntity entity = logsMapper.selectById(logsEntity.getTaskId());
        System.out.println("保存后得到的日志对象:"+entity);

        entity.setPriority(3);
        logsMapper.updateById(entity);
        TaskInfoLogsEntity byId = logsMapper.selectById(entity.getTaskId());
        System.out.println("第一次修改后查询得到的日志对象:"+byId);

        entity.setPriority(5);
        logsMapper.updateById(entity);

        byId = logsMapper.selectById(entity.getTaskId());
        System.out.println("第二次修改后查询得到的日志对象:"+byId);
    }
    
}
