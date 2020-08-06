package com.itheima.service;

import com.itheima.mapper.PermissionMapper;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Permission;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PermissionService {

    //成员位置,获取SqlSessionFactory对象
    private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

    /**
     * 权限数据分页业务
     * 接受web传递的参数 当前页数 ,每页多少条
     * 调用持久层进行数据获取
     * 封装好PageBean对象
     */
    public PageBean<Permission> queryByPage(int currentPage,int pageSize){
        PageBean<Permission> pb = new PageBean<Permission>();

        //pb对象存储当前页数
        pb.setCurrentPage( currentPage );

        //pb对象存储每页显示条数
        pb.setPageSize( pageSize );

        //持久层,查询需要的数据,limit分页查询
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        List<Permission> list = permissionMapper.queryByPage( (currentPage-1)*pageSize,pageSize  );
        //pb对象,存储查询的数据
        pb.setList(list);

        //持久层,查询所有数据的总条数
        long totalCount = permissionMapper.queryByCount();
        //pb对象存储总条数
        pb.setTotalCount(totalCount);

        //总页数 = (总条数/每页显示条数) 向上取整
        //pb对象存储总页数
        pb.setTotalPage( (int) Math.ceil ((totalCount*1.0/pageSize))   );

        MyBatisUtils.close(sqlSession);
        return pb;
    }


    /**
     * 更新数据
     * web传递pojo对象
     * 代理接口
     */
    public void updatePermission(Permission permission){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        permissionMapper.updatePermission(permission);
        MyBatisUtils.commitAndClose(sqlSession);
    }

    /**
     * 根据主键查询
     * web传递主键
     * 代理接口,返回pojo对象
     */
    public Permission queryById(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        Permission permission = permissionMapper.queryById(id);
        MyBatisUtils.close(sqlSession);
        return permission;
    }

    /**
     * 删除权限方法
     * web层传递int主键
     * 代理mapper接口
     */
    public void delPermission(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        permissionMapper.delPermission(id);
        MyBatisUtils.commitAndClose(sqlSession);
    }

    /**
     * 新增权限方法
     * web层传递pojo对象
     * 代理mapper接口
     */
    public void addPermission(Permission permission){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        permissionMapper.addPermission(permission);
        //提交事务,释放资源
        MyBatisUtils.commitAndClose(sqlSession);
    }

    /**
     * 条件查询权限数据
     * web层传递pojo对象
     * 代理mapper接口
     */
    public  List<Permission> queryByWhere(Permission permission){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        List<Permission> permissionList = permissionMapper.queryByWhere(permission);
        MyBatisUtils.close(sqlSession);
        return permissionList;
    }

    /**
     * 定义方法,获取所有的权限数据
     * 返回给web层
     * 调用持久层 mapper
     *
     * 需要使用代理开发,代理出mapper接口的实现类
     * 需要对象 sqlSession对象.getMapper()
     * 先要获取sqlSessionFactory对象
     */
    public List<Permission> queryAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //代理PermissionMapper接口,生成实现类对象
        PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
        List<Permission> permissionList = permissionMapper.queryAll();
        //释放资源
        MyBatisUtils.close(sqlSession);
        return permissionList;
    }
}
