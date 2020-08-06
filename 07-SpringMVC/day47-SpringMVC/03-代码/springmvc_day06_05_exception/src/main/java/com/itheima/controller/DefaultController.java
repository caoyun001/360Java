package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("default")
public class DefaultController {

    /**
     * 返回值为String类型, 通过SpringMVC框架 使用重定向 实现页面跳转(注意: 不可以将SpringMVC 提供的Model, ModelMap封装的数据 请求转发到目标页面)
     *
     * 格式用法: redirect:请求的地址
     */
    @RequestMapping("gotoResultRedirect")
    public String gotoResultRedirect(ModelMap modelMap){
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultRedirect");
        //指定页面
        //请求转发
        return "redirect:/default/gotoResultModelMap.do";
    }

    /**
     * 返回值为String类型, 通过SpringMVC框架 使用请求转发 实现页面跳转(注意: 可以将SpringMVC 提供的Model, ModelMap封装的数据 请求转发到目标页面)
     *
     * 格式用法: forward:请求的地址
     */
    @RequestMapping("gotoResultForward")
    public String gotoResultForward(ModelMap modelMap){
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultForward");
        //指定页面
        //请求转发
        return "forward:/default/gotoResultModelMap.do";
    }

    /**
     * 返回值为void类型, 使用Response跳转页面 (注意: 无法将SpringMVC 提供的Model, ModelMap封装的数据 重定向到目标页面)
     */
    @RequestMapping("gotoResultResponse")
    public void gotoResultResponse(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultResponse");
        //指定页面
        //重定向
        //response.sendRedirect("http://localhost:8080/default/gotoResultModelMap.do");
        response.sendRedirect(request.getContextPath()+"/default/gotoResultModelMap.do");
    }

    /**
     * 返回值为void类型, 使用Request对象 实现页面跳转(注意: 无法将SpringMVC 提供的Model, ModelMap封装的数据 请求转发到目标页面)
     * @param modelMap
     * @return
     */
    @RequestMapping("gotoResultRequest")
    public void gotoResultRequest(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过SpringMVC框架把封装数据到Request域中( 跳转页面的方式必须采用的是SpringMVC框架提交的方式, 才能把数据 传递过去 )
        modelMap.addAttribute("nowDate", new Date()+"====gotoResultRequest");
        //指定页面
        //请求转发
//        request.setAttribute("键", "值");
        request.getRequestDispatcher("/default/gotoResultModelMap.do").forward(request, response);
    }

    /**
     * @param modelMap 实现类 , 提供了向Request域 封装数据的操作
     * @return 指定的页面路径
     */
    @RequestMapping("gotoResultModelMap")
    public String gotoResultModelMap(ModelMap modelMap){
        //抛异常
        int[] arr = new int[0];
        System.out.println("arr = " + arr[5]); //数组角标越界异常

        //封装数据
        //modelMap.addAttribute("nowDate", new Date()+"====gotoResultModelMap");
        System.out.println("gotoResultModelMap方法 执行了");
        //指定页面
        return "result";
    }

    /**
     * @param model 接口, 提供了向Request域 封装数据的操作
     * @return 指定的页面路径
     */
    @RequestMapping("gotoResultModel")
    public String gotoResultModel(Model model){
        //抛异常
        List<String> list = null;
        System.out.println("list.size() = " + list.size()); //空指针异常

        //封装数据
        model.addAttribute("nowDate", new Date()+"====gotoResultModel");
        //指定页面
        return "result";
    }
}
