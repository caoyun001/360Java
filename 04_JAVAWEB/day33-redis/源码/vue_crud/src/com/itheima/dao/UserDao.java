package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
    /**
     * 删除数据
     * 业务层传递主键
     */
    public void delete(String id) throws SQLException {
        String sql = "delete from tb_user where id = ?";
        qr.update(sql,id);
    }

    /**
     * 修改数据
     * 业务层传递User对象
     */
    public void update(User user) throws SQLException {
        String sql = "update tb_user set name = ?, money = ? where id = ?";
        Object[] params = {user.getName(),user.getMoney(),user.getId()};
        qr.update(sql,params);
    }

    /**
     * 修改数据的回显
     * 业务层传递id主键
     * 返回User对象
     */
    public User findById(String id) throws SQLException {
        String sql = "select * from tb_user where id = ?";
        return qr.query(sql,new BeanHandler<User>(User.class),id);
    }

    /**
     * 新增用户数据
     * 业务层传递pojo对象
     */
    public void register(User user) throws SQLException {
        String sql = "insert into tb_user values(?,?,?)";
        Object[] params = {null,user.getName(),user.getMoney()};
        qr.update(sql,params);
    }

    /**
     * 查询所有用户数据
     * 结果集是集合,返回业务层
     */
    public List<User> findAll() throws SQLException {
        String sql = "select * from tb_user";
        return qr.query(sql,new BeanListHandler<User>(User.class));
    }
}
