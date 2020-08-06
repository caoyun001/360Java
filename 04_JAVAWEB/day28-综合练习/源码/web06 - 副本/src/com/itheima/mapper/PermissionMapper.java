package com.itheima.mapper;

import com.itheima.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     * 方法,查询所有的权限数据
     * 聚合函数
     */
    long queryByCount();

    /**
     * 方法,用于分页查询
     * 传递2个参数 limit 参数1,参数2
     * 参数1: 数据表开始索引 (当前页-1)*每页显示条数
     * 参数2: 每页显示的条数
     */
    List<Permission> queryByPage(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 更新权限
     * 传递参数pojo对象
     * 返回int
     */
    int updatePermission(Permission permission);

    /**
     * 根据权限主键查询
     * 返回结果pojo对象
     * 参数主键
     */
    Permission queryById(Integer id);

    /**
     * 删除权限的方法
     * 参数int主键
     * 返回值int
     */
    int delPermission(Integer id);

    /**
     * 新增权限方法
     * 参数pojo对象
     * 返回值int
     */
    int addPermission(Permission permission);

    /**
     * 条件查询权限方法
     * 参数是pojo对象
     * 返回值是 集合
     */
    List<Permission> queryByWhere(Permission permission);

    /**
     * 查询所有权限数据方法,返回值集合
     */
    List<Permission> queryAll();
}
