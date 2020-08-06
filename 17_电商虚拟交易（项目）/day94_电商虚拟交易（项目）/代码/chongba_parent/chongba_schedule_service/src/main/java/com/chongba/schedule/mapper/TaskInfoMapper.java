package com.chongba.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chongba.schedule.pojo.TaskInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by 传智播客*黑马程序员.
 */
public interface TaskInfoMapper extends BaseMapper<TaskInfoEntity>{
    
    @Select("select * from taskinfo")
    public List<TaskInfoEntity> selectAll();

    @Select("select * from taskinfo where task_type = #{task_type} and priority = #{priority}")
    List<TaskInfoEntity> queryAll(@Param("task_type") int type, @Param("priority") int priority);
    
    @Select("select * from taskinfo where task_type = #{task_type} and priority = #{priority} and execute_time <=#{futureTime}")
    List<TaskInfoEntity> queryFuture(@Param("task_type")int taskType,  @Param("priority")int priority, @Param("futureTime") Date futureTime);
}
