//package com.itheima.web;
//
//import com.itheima.pojo.PageBean;
//import com.itheima.pojo.Permission;
//import com.itheima.service.PermissionService;
//import org.apache.commons.beanutils.BeanUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Map;
//
///**
// * 处理客户端的所有关于权限的功能请求
// * 获取客户端的指定参数 operator的值
// * 决定客户端要做什么,调用不同的方法
// */
//@WebServlet(urlPatterns = "/permission")
//public class PermissionServlet extends HttpServlet {
//    private PermissionService service = new PermissionService();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取客户的指定参数operator
//        String operator = request.getParameter("operator");
//       // System.out.println(operator);
//        try {
//            //就是客户端的请求内容,调用不同的方法
//            Class clazz = this.getClass();
//            //获取执行的方法 operator,方法名
//            Method method = clazz.getMethod(operator, HttpServletRequest.class, HttpServletResponse.class);
//            method.invoke(this,request,response);
//        }catch (Exception ex){ex.printStackTrace();
//            System.out.println();}
//    }
//    /**
//     *  实现思想:
//     *    1: 获取客户端的提交参数
//     *      获取当前的页数,如果拿不到页数,默认1
//     *
//     *    2: 定义出每页显示多少条 5
//     *
//     *    3: 当前页和每页显示条数,传递业务层去
//     *      接收业务层返回的PageBean对象
//     *
//     *    4: PageBean对象存储在request域中,响应回页面
//     *      permissionPage.jsp
//     */
//    public void queryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取客户端提交上来的当前页数
//        String currentPage = request.getParameter("currentPage");
//        //判空
//        if (currentPage == null){
//            currentPage = "1";
//        }
//        //定义每页显示的条数
//        int pageSize = 5;
//
//        //调用业务层的方法,传递 当前页数和每页显示条数
//        //获取业务层封装的PageBean对象
//        PageBean<Permission> pageBean = service.queryByPage(Integer.parseInt(currentPage), pageSize);
//        //对象存储在域中
//        request.setAttribute("pageBean",pageBean);
//        //转发
//        request.getRequestDispatcher("/permissionPage.jsp").forward(request,response);
//    }
//
//    /**
//     * 修改权限的操作
//     * 获取客户端请求的参数
//     * 封装成pojo对象
//     * 调用业务层传递pojo
//     * 响应客户所有的数据
//     */
//    public void updatePermission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, String[]> map = request.getParameterMap();
//        Permission permission = new Permission();
//        try {
//            BeanUtils.populate(permission,map);
//        }catch (Exception ex){ex.printStackTrace();}
//       //业务层,传递pojo对象
//        service.updatePermission(permission);
//        //查询全部的数据
//        queryAll(request, response);
//    }
//
//    /**
//     * 修改权限的回显操作
//     * 获取客户端请求的主键值
//     */
//    public void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        //调用业务层方法queryById,传递主键,获取查询的结果集
//        Permission permission = service.queryById(Integer.parseInt(id));
//        //存在request域中
//        request.setAttribute("permission",permission);
//        //转发到updatePermission.jsp
//        request.getRequestDispatcher("/updatePermission.jsp").forward(request,response);
//    }
//
//    /**
//     * 方法处理客户的删除权限
//     */
//    public void delPermission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取主键id
//        String id = request.getParameter("id");
//        //业务层的方法,删除
//        service.delPermission( Integer.parseInt(id) );
//        //响应客户端,还是查询全部的数据
//        queryAll(request,response);
//    }
//
//    /**
//     * 方法处理客户的新增权限的请求
//     * 方法名字 addPermission
//     * 接收客户的请求参数 3 (中文) 过滤器
//     * 3个参数,封装到pojo对象
//     * 调用业务层方法,传递pojo对象
//     * 客户端响应
//     */
//    public void addPermission(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       //接收客户的请求参数 3
//        Map<String, String[]> map = request.getParameterMap();
//        //表单参数封装到pojo对象
//        Permission permission = new Permission();
//        //BeanUtils静态方法populate
//        try {
//            BeanUtils.populate(permission, map);
//        }catch (Exception ex){ex.printStackTrace();}
//        //调用业务层方法,传递pojo对象
//        service.addPermission(permission);
//        //客户端响应, 应该让客户看到添加后的结果
//        //客户端再次显示全部的权限数据
//        queryAll(request, response);
//    }
//
//
//    /**
//     *  方法处理客户端获取所有权限数据的请求
//     *  方法名字 queryAll,参数,请求对象和响应对象
//     */
//    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        //获取查询结果集List集合
//        List<Permission> permissionList = service.queryAll();
//        //客户端响应,展示数据(List集合)
//        //集合存储在域对象中
//        request.setAttribute("permissionList",permissionList);
//        //转发: 权限数据的展示页面
//        request.getRequestDispatcher("/permission.jsp").forward(request,response);
//    }
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}
