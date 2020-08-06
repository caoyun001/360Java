package com.chongba.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chongba.schedule.pojo.TaskInfoEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 传智播客*黑马程序员.
 */
public interface TaskInfoMapper extends BaseMapper<TaskInfoEntity>{
    
    @Select("select * from taskinfo")
    public List<TaskInfoEntity> selectAll();
}
