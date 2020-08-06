package com.itheima.login;

import com.itheima.pojo.Users;
import com.itheima.utils.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 处理登录的Servlet
 *   1: 获取客户端请求的数据
 *     用户名和密码
 *     request是负责请求的对象
 *     方法: String getParameter(String 表单name属性值)获取客户端的表单提交数据

 *   2: 使用QueryRunner查询数据表
 *
 *   3: 获取查询的结果集
 *     判定:
 *       有结果集,登录成功,响应客户端
 *       没有结果集,登录失败,响应客户端
 */
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1: 获取客户端请求的数据
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        //2 QueryRunner操作数据库
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        //拼写登录查询的SQL语句
        String sql = "select * from users where username=? and password = ?";
        //调用方法query查询 BeanHandler,查询的结果集封装成Users对象
        Users users = null;
        try {
             users = qr.query(sql, new BeanHandler<Users>(Users.class), username, password);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        //3: 获取查询的结果集
        //判断的是users对象
        if(users == null){
            //没有查询到数据,登录失败
            response.getWriter().write("login fail");
        }else{
            //查询到数据,登录成功
            response.getWriter().write("login success");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
