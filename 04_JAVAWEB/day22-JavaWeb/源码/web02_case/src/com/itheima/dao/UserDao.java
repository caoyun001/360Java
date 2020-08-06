package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 处理用户数据的持久层
 */
public class UserDao {
    /**
     * 方法,实现注册
     * 新增数据: 业务层传递User对象
     */
    public void register(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        //拼写insert语句
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        //定义数组,存储User对象中的参数
        Object[] params = {null,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getGender(),user.getBirthday()};
        //执行新增
        qr.update(sql,params);
    }
}
