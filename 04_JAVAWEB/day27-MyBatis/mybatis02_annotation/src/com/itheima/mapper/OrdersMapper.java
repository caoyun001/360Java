package com.itheima.mapper;

import com.itheima.pojo.Orders;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrdersMapper {
    /**
     * 根据用户主键查询订单
     * orders表的列user_id
     */
    @Select("select  o.id,o.user_id,o.number,o.createtime,o.note from orders o where o.user_id=#{id}")
    List<Orders> queryOrdersByUserId();


    /**
     * 订单对用户的一对一查询
     * 延迟加载
     *
     *  配置手动映射的注解
     *  @Results
     *  注解属性: Result[] value() default {};
     *  属性是另一个注解数组
     *
     *  @Result注解
     *    注解属性 boolean id() default false; 是不是主键
     *    注解属性 column 数据表列名
     *    注解属性 property pojo对象的属性名
     *    注解属性 one 配置一对一的
     *    注解属性 javaType 查询结果存储的数据类型
     *
     *    @One注解:
     *      属性 select 关联的第二次查询语句
     *        SQL2: 根据主键查询用户,写在了 UserMapper接口上
     *        查询的条件 id = 订单表的user_id值
     *      属性fetchType 加载类型
     */

    @Select(" select o.id,o.user_id,o.number,o.createtime,o.note from orders o")
    @Results({
            @Result(id = true, column = "id",property = "id"),
            @Result(column = "userId",property = "user_id"),
            @Result(column = "number",property = "number"),
            @Result(column = "createtime",property = "createtime"),
            @Result(column = "note",property = "note"),
            @Result(column = "user_id" ,property = "user", javaType = User.class,
                    one = @One(select = "com.itheima.mapper.UserMapper.queryUserById",fetchType = FetchType.LAZY) )
    })
    List<Orders> queryOrdersUser();



}
