package com.chongba.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 传智播客*黑马程序员.
 */
@Data
public class Task implements Serializable{
    
    private static final long serialVersionUID = -852887735827147097L;


    private Long taskId;
    /**
     * 类型
     */
    private Integer taskType;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 执行id
     */
    private long executeTime;

    /**
     * task参数
     */
    private byte[] parameters;
}
