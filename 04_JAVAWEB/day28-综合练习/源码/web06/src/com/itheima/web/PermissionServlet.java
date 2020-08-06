package com.itheima.web;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Permission;
import com.itheima.service.PermissionService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/permission")
public class PermissionServlet extends HttpServlet {

    private PermissionService service = new PermissionService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取客户端请求参数
         * 反射调用相关方法
         */
        try {
            String operator = request.getParameter("operator");
            Class clazz = this.getClass();
            Method method = clazz.getMethod(operator, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 处理权限分页显示
     * 获取客户端提交的当前页数 (如果没有,默认第一页)
     * 定义每页显示多少条
     * 数据传递到业务层,获取封装好的对象PageBean,转发回页面
     */
    public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端提交的当前页数 (如果没有,默认第一页)
        String currentPage = request.getParameter("currentPage");
        if (currentPage == null)
            currentPage = "1";
        //定义每页多少条
        int pageSize = 5;

        //传 当前页数 ,每页多少条 到业务层,获取PageBean对象
        PageBean<Permission> pb = service.queryByPage(Integer.parseInt(currentPage), pageSize);

        request.setAttribute("pageBean", pb);

        request.getRequestDispatcher("/permissionPage.jsp").forward(request, response);

        System.out.println(pb);
    }


    /**
     * 客户端更新权限的请求
     * 获取客户端全部数据
     * 封装到pojo对象
     * 调用业务层
     * 响应客户端全部的数据
     */
    public void updatePermission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Permission permission = new Permission();
        try {
            BeanUtils.populate(permission, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.updatePermission(permission);
        queryAll(request, response);

    }

    /**
     * 客户端主键查询的请求
     * 数据的回显
     * 获取提交的主键数据
     * 调用业务层查询
     * 响应: 响应查询到数据
     */
    public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Permission permission = service.queryById(Integer.parseInt(id));
        request.setAttribute("permission", permission);
        request.getRequestDispatcher("/updatePermission.jsp").forward(request, response);
    }

    /**
     * 删除权限方法
     * 接受客户端提交数据,主键
     * 调用业务层传递主键
     * 响应客户端所有数据
     */
    public void delPermission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //调用业务层传递主键
        service.delPermission(Integer.parseInt(id));
        queryAll(request, response);
    }


    /**
     * 新增权限的请求
     * 获取客户端提交的数据
     * 封装pojo对象
     * 传递业务层
     * 客户端响应全部数据
     */
    public void addPermission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端提交的数据
        Map<String, String[]> map = request.getParameterMap();
        //封装pojo对象
        Permission permission = new Permission();
        try {
            BeanUtils.populate(permission, map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //传递业务层
        service.addPermission(permission);

        //客户端响应全部数据
        queryAll(request, response);
    }

    /**
     * 多条件查询权限列表的请求
     * 获取2个条件
     * 传递到业务层,数据查询
     * 返回的结果集,集合
     */
    public void queryByWhere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String keyword = request.getParameter("keyword");

        Permission permission = new Permission();
//        permission.setKey("%" + name + "%");
//        permission.setKeyword("%" + keyword + "%");
        List<Permission> permissionList = service.queryByWhere(permission);
        request.setAttribute("permissionList", permissionList);
        request.getRequestDispatcher("/permission.jsp").forward(request, response);

    }

    /**
     * 处理客户端获取所有权限列表的请求
     * 调用业务层获取所有数据
     * 存储在request域对象,转发页面permission.jsp
     */
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Permission> permissionList = service.queryAll();
        request.setAttribute("permissionList", permissionList);
        request.getRequestDispatcher("/permission.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
