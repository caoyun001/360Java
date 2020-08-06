package com.chongba.schedule;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chongba.schedule.mapper.TaskInfoMapper;
import com.chongba.schedule.pojo.TaskInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 传智播客*黑马程序员.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
public class TaskInfoMapperTest {
    
    @Autowired
    private TaskInfoMapper taskInfoMapper;
    
    @Test
    public void test1(){
        //保存
        TaskInfoEntity taskInfoEntity = new TaskInfoEntity();
        taskInfoEntity.setExecuteTime(new Date());
        taskInfoEntity.setPriority(1);
        taskInfoEntity.setTaskType(1001);
        taskInfoEntity.setParameters("test".getBytes());
        taskInfoMapper.insert(taskInfoEntity);
        System.out.println("保存完成后返回主键值:"+taskInfoEntity.getTaskId());


        TaskInfoEntity infoEntity = taskInfoMapper.selectById(taskInfoEntity.getTaskId());
        System.out.println("根据主键查询得到的数据:"+infoEntity);


        infoEntity.setTaskType(1002);
        infoEntity.setPriority(10);
        taskInfoMapper.updateById(infoEntity);
    }
    
    @Test
    public void test2(){
        taskInfoMapper.deleteById(1181473027074838529L);
    }
    
    @Test
    public  void test3(){
        List<TaskInfoEntity> entities = taskInfoMapper.selectList(null);
        for (TaskInfoEntity entity : entities) {
            System.out.println(entity);
        }
    }
    @Test
    public  void  test4(){
        QueryWrapper<TaskInfoEntity> queryWrapper = new QueryWrapper<TaskInfoEntity>();
        queryWrapper.eq("task_type",1002);// where task_type = 1002
        queryWrapper.orderByDesc("priority");// order by priority desc
        List<TaskInfoEntity> entities = taskInfoMapper.selectList(queryWrapper);
        for (TaskInfoEntity entity : entities) {
            System.out.println(entity);
        }
    }
    
    @Test
    public void test5(){
        List<TaskInfoEntity> entities = taskInfoMapper.selectAll();
        for (TaskInfoEntity entity : entities) {
            System.out.println(entity);
        }
    }

    public void initGroupData(){
        //构造不同分组的任务数据
        for(int i=0;i<20;i++){
            TaskInfoEntity taskInfo = new TaskInfoEntity();
            taskInfo.setExecuteTime(new Date());
            if(i<10){
                taskInfo.setTaskType(1001);
                taskInfo.setPriority(50);
            }else {
                taskInfo.setTaskType(1002);
                taskInfo.setPriority(100);
            }
            taskInfo.setParameters("testGroup".getBytes());
            taskInfoMapper.insert(taskInfo);
        }
    }
    
    @Test
    public void testGroup(){
        initGroupData();
        //mybatis-plus进行分组查询
        QueryWrapper<TaskInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.select("task_type","priority");
        wrapper.groupBy("task_type","priority");
        List<Map<String, Object>> maps = taskInfoMapper.selectMaps(wrapper);
        for (Map<String, Object> map : maps) {
            String task_type = String.valueOf(map.get("task_type"));
            String priority = String.valueOf(map.get("priority"));
            String key = task_type+"_"+priority;//分组key
            System.out.println(key);
        }
    }
}
