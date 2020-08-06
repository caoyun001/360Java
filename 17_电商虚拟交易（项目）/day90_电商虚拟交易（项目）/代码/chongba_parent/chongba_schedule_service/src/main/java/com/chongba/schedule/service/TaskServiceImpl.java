package com.chongba.schedule.service;

import com.chongba.entity.Constants;
import com.chongba.entity.Task;
import com.chongba.exception.ScheduleSystemException;
import com.chongba.exception.TaskNotExistException;
import com.chongba.schedule.inf.TaskService;
import com.chongba.schedule.mapper.TaskInfoLogsMapper;
import com.chongba.schedule.mapper.TaskInfoMapper;
import com.chongba.schedule.pojo.TaskInfoEntity;
import com.chongba.schedule.pojo.TaskInfoLogsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 传智播客*黑马程序员.
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskInfoMapper infoMapper;
    
    @Autowired
    private TaskInfoLogsMapper logsMapper;
    
    @Override
    public long addTask(Task task) throws ScheduleSystemException {
        /**
         * 向任务表中添加数据
         * 向任务日志表中添加数据
         */
        try {
            TaskInfoEntity infoEntity = new TaskInfoEntity();
            infoEntity.setTaskType(task.getTaskType());
            infoEntity.setPriority(task.getPriority());
            infoEntity.setParameters(task.getParameters());
            infoEntity.setExecuteTime(new Date(task.getExecuteTime()));

            infoMapper.insert(infoEntity);
            task.setTaskId(infoEntity.getTaskId());


            TaskInfoLogsEntity logsEntity = new TaskInfoLogsEntity();
            logsEntity.setTaskId(infoEntity.getTaskId());
            logsEntity.setTaskType(infoEntity.getTaskType());
            logsEntity.setPriority(infoEntity.getPriority());
            logsEntity.setParameters(infoEntity.getParameters());
            logsEntity.setExecuteTime(infoEntity.getExecuteTime());
            logsEntity.setVersion(1);
            logsEntity.setStatus(Constants.SCHEDULED);
            logsMapper.insert(logsEntity);
        } catch (Exception e) {
            //日志记录
            log.error("add task exception ,taskId={}",task.getTaskId());
            throw new ScheduleSystemException(e.getMessage());
        }
        return task.getTaskId();
    }

    @Override
    public boolean cancelTask(long taskId) throws TaskNotExistException {
        /**
         * 删除任务表中数据
         * 更新日志表中的任务状态:2
         */
        boolean success = false;
        try {
            infoMapper.deleteById(taskId);
            TaskInfoLogsEntity logsEntity = logsMapper.selectById(taskId);
            logsEntity.setStatus(Constants.CANCELLED);
            logsMapper.updateById(logsEntity);
            success = true;
        } catch (Exception e) {
            log.error("cancel task exception ,taskId={}",taskId);
            throw  new TaskNotExistException(e.getMessage());
        }
        return success;
    }
}
