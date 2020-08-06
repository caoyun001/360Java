package com.chongba.schedule.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 传智播客*黑马程序员.
 */
@Data // 
@ToString
@NoArgsConstructor

@TableName("taskinfo")
public class TaskInfoEntity implements Serializable{

    private static final long serialVersionUID = -3218564191925663119L;
    
    @TableId(type = IdType.ID_WORKER)
    private Long taskId;
    
    @TableField
    private Date executeTime;
    
    @TableField
    private Integer priority;
    
    @TableField
    private Integer taskType;
    
    @TableField
    private byte[] parameters;
}
