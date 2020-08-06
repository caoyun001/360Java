package com.chongba.schedule.inf;

import com.chongba.entity.Task;
import com.chongba.exception.ScheduleSystemException;
import com.chongba.exception.TaskNotExistException;

/**
 * Created by 传智播客*黑马程序员.
 */
public interface TaskService {

    /**
     * 添加任务接口
     * @param task  任务对象
     * @return      任务的id
     * @throws ScheduleSystemException
     */
    public long addTask(Task task) throws ScheduleSystemException;


    /**
     * 根据任务id取消任务
     * @param taskId   任务id
     * @return          是否取消成功
     * @throws TaskNotExistException
     */
    public boolean cancelTask(long taskId) throws TaskNotExistException;
    
}
