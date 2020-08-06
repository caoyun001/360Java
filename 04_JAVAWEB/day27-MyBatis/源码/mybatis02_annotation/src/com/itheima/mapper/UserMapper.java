package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    /**
     * 定义方法,用户对订单一对多
     * 延迟加载
     * @Results配置映射
     *
     * 用户的主键,查询订单的外键 user_id
     *
     * select = "" 根据用户主键查询订单
     */
    @Select("select u.id ,u.username,u.sex,u.birthday,u.address from user u")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username" , property ="username" ),
            @Result(column = "sex" , property ="sex" ),
            @Result(column = "birthday" , property ="birthday" ),
            @Result(column = "address" , property ="address" ),
            @Result(column = "id",property ="ordersList", javaType = List.class,
                    many = @Many(select = "com.itheima.mapper.OrdersMapper.queryOrdersByUserId",fetchType = FetchType.LAZY))
    })
    List<User> queryUserOrders();

    /**
     * 定义方法,根据主键查询用户
     */
    @Select("select id ,username,sex,birthday,address from user where id = #{id} ")
    User queryUserById(Integer id);

    /**
     * 根据多个主键删除用户
     * 标签 foreach
     */
    @Delete("<script>delete from user where id in <foreach" +
            " collection=\"list\" open=\"(\" close=\")\" separator=\",\" item=\"id\">" +
            "#{id}" +
            "</foreach></script>")
    int deleteUserById(List<Integer> list);

    /**
     * 查询用户表,条件不确定,使用动态SQL
     *
     */
    @Select("<script>select id ,username,sex,birthday,address from user <where>" +
            "<if test=\"username!='' and username != null\">" +
            " and username like #{username}" +
            "</if>" +
            "<if test=\"sex!='' and sex !=null\">" +
            "  and sex = #{sex}" +
            "</if>" +
            "</where></script>")
    List<User> queryUserByWhere(User user);

    /**
     *  注解开发: 注解取消xml配置文件
     *  新增数据,提供注解 @Insert
     *  注解的属性value,配置的就是SQL语句
     *
     *  获取新增后的主键值 注解@SelectKey
     *  注解属性 : statement 执行SQL语句
     *  注解属性 : before insert语句执行的顺序
     *  注解属性 : keyProperty 新增后的主键,存储那里,存储在pojo对象id
     *  注解属性 : resultType 执行SQL语句后的数据类型
     *
     *  注解: @options
     *    属性: useGeneratedKeys 是否使用刚生成主键
     */
    @Insert("insert into user values (null,#{username},#{sex},#{birthday},#{address})")
    @Options(useGeneratedKeys = true,keyProperty="id")
    //@SelectKey(statement = "SELECT LAST_INSERT_ID ()",before = false,keyProperty = "id",resultType = Integer.class)
    int saveUser(User user);

    /**
     * 更新数据 @Update注解
     */
    @Update("update user set username=#{username},sex=#{sex},address=#{address} where id=#{id}")
    int updateUser(User user);

    /**
     * 查询所有的用户数据
     * 注解 @Select
     */
    @Select("select id ,username,sex,birthday,address from user")
    List<User> queryUser();
}
