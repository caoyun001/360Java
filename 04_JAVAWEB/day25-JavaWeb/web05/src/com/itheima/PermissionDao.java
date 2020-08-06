package com.itheima;

import com.itheima.pojo.Permission;
import com.itheima.mybatis.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 *  操作权限表Permission,持久层
 */
public class PermissionDao {
    //创建QueryRunner对象,执行SQL语句的
    //被很多的方法使用
    private QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());

    /**
     * 查询获取权限表的所有数据,聚合函数count
     */
    public long getTotalCount() throws SQLException {
        String sql = "select count(id) from t_permission";
        //执行查询,结果是单值,使用scalarHandler
        return qr.query(sql,new ScalarHandler<Long>());
    }

    /**
     * 分页查询
     * SELECT * FROM t_permission LIMIT 0,5
     * 业务层传递 limit的2个参数,返回List集合
     */
    public List<Permission> queryByPage(int currentPage,int pageSize) throws SQLException {
        //拼写分页的查询语句
        String sql = "select * from t_permission limit ?,?";
        //执行查询
        List<Permission> list =
                qr.query(sql,new BeanListHandler<Permission>(Permission.class),currentPage,pageSize);
        return list;
    }

    /**
     * 修改权限的方法
     * 业务层传递pojo对象
     * 取出对象数据,update操作
     *
     * Permission{id=0, name='学科删除2', keyword='COURSE_DELETE2', description='删除学科2'}
     */
    public void updatePermission(Permission permission) throws SQLException {
        //拼写SQL语句,更新的
        String sql = "update t_permission set name = ? , keyword = ? ,description = ? where id= ?";
        //取出数据组成数组
        Object[] params = {permission.getName(),permission.getKeyword(),permission.getDescription(),permission.getId()};
        qr.update(sql,params);
    }

    /**
     * 修改权限的回显方法
     * 业务层传递主键,查询
     * 返回值Permission
     */
    public Permission queryById(int id) throws SQLException {
        //拼写主键查询SQL
        String sql = "select * from t_permission where id = ?";
        Permission permission = qr.query(sql,new BeanHandler<Permission>(Permission.class),id);
        return permission;
    }

    /**
     * 删除权限的方法
     * 参数,主键,业务层传递
     */
    public void delPermission(int id) throws SQLException {
        //删除的SQL语句
        String sql = "delete from t_permission where id = ?";
        qr.update(sql,id);
    }
    /**
     * 新增权限的方法
     * 参数pojo对象
     * 取出pojo对象中的三个参数,写入数据表
     * 参数是service层传递
     */
    public void addPermission(Permission permission) throws SQLException {
        //拼写新增的SQL
        String sql = "insert into t_permission values(?,?,?,?)";
        //取出Permission对象的三个参数,存在数组中
        Object[] params = {null,permission.getName(),permission.getKeyword(),permission.getDescription()};
        //执行新增SQL语句
        qr.update(sql,params);
    }

    /**
     * 查询Permission表的所有数据
     * 结果封装成List集合,返回到业务层
     */
    public List<Permission> queryAll()throws SQLException{
        //查询所有权限的SQL语句
        String sql = "select * from t_permission";
        //执行查询,使用BeanListHandler
        List<Permission> permissionList = qr.query(sql,new BeanListHandler<Permission>(Permission.class));
        return permissionList;
    }
}
