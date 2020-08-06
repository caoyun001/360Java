package com.itheima.mapper;

import com.itheima.pojo.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * 进行多表查询,实现数据的三个表查询
     * 角色表,中间表,用户表
     */
    List<Role> queryRoleUser();
}
