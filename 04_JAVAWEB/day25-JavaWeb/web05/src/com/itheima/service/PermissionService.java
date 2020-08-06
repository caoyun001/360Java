package com.itheima.service;

import com.itheima.PermissionDao;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Permission;

import java.sql.SQLException;
import java.util.List;

/**
 * 处理权限表的业务
 */
public class PermissionService {
    //创建dao层对象
   private PermissionDao permissionDao = new PermissionDao();

    /**
     * 分页查询的业务
     * 接收web层传递的参数  当前页数和每页显示条数
     * 调用dao,查询数据,封装PageBean对象
     */
    public PageBean<Permission> queryByPage(int currentPage, int pageSize){
        PageBean<Permission> pb = new PageBean<Permission>();
        try {
            //存储当前页数
            pb.setCurrentPage(currentPage);

            //存储每页显示的条数
            pb.setPageSize(pageSize);

            //存储要显示的权限数据 List集合,找dao层获取
            //调用dao层方法queryByPage,传递计算好的参数,获取查询结果集
            List<Permission> list =
                    permissionDao.queryByPage((currentPage - 1) * pageSize, pageSize);
            //集合List,存在到pageBean中
            pb.setList(list);

            //存储共有多少条数据,找dao层获取
            long totalCount = permissionDao.getTotalCount();
            pb.setTotalCount(totalCount);

            //存储一共有多少页
            //计算 (总条数/每页显示的条数) 向上去整  14.0 / 5 = 2.22
            int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
            pb.setTotalPage(totalPage);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return pb;
    }


    /**
     * 修改数据的方法
     * web层调用方法updatePermission,传递pojo对象
     * 调用dao层方法,传递pojo对象
     */
    public void updatePermission(Permission permission){
        try {
            permissionDao.updatePermission(permission);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改回显的方法
     * 调用dao层方法 queryById,接收结果集Permission对象
     * web调用业务层的方法,传递主键
     */
    public Permission queryById(int id){
        Permission permission = null;
        try {
            permission = permissionDao.queryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permission;
    }

    /**
     * 调用dao层方法,delPermission删除权限
     * 传递主键,主键是web层传递
     */
    public void delPermission(int id){
        try {
            permissionDao.delPermission(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用dao层的方法 addPermission 新增权限
     * 被web层调用传递pojo对象
     * 调用dao层方法,传递pojo对象
     */
    public void addPermission(Permission permission){
        try {
            permissionDao.addPermission(permission);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用dao层的方法 queryAll
     * 获取结果集List集合
     * 集合返回到web层
     */
    public List<Permission> queryAll(){
        List<Permission> permissionList = null;
        try {
            permissionList = permissionDao.queryAll();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
       return permissionList;
    }
}
