package com.itheima.controller;

import com.itheima.com.itheima.pojo.QueryVo;
import com.itheima.com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("params")
public class ParamsController {

    //功能10 : 获取指定Cookie的value值
    @RequestMapping("sendParamsCookie")
    public ModelAndView sendParamsCookie(@CookieValue("JSESSIONID") String cookie, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+cookie);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能9 : 获取请求头的指定信息
    @RequestMapping("sendParamsHeader")
    public ModelAndView sendParamsHeader(@RequestHeader("User-Agent") String header, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+header);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能8 : 字符串转成日期对象
    @RequestMapping("sendParamsDate")
    public ModelAndView sendParamsDate(Date date, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", date+"====gotoParamsDate");
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能7: 绑定Map集合包装pojo对象
    @RequestMapping("gotoParamsMap")
    public ModelAndView gotoParamsMap(QueryVo queryVo, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+queryVo);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能6: 绑定List集合包装pojo对象
    @RequestMapping("gotoParamsList")
    public ModelAndView gotoParamsList(QueryVo queryVo, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+queryVo);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能5: 绑定pojo对象的包装对象
    @RequestMapping("gotoParamsQueryVo")
    public ModelAndView gotoParamsQueryVo(QueryVo queryVo, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+queryVo);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能4: 绑定pojo对象
    @RequestMapping("gotoParamsPojo")
    public ModelAndView gotoParamsPojo(User user, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+user);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能3: @RequsestParam注解的使用
    @RequestMapping("gotoParamsRequestParam")
    public ModelAndView gotoParamsRequestParam(@RequestParam("id") Integer ids, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+ids);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能2: 绑定简单的数据类型
    @RequestMapping("gotoParamsBase")
    public ModelAndView gotoParamsBase(Boolean isVIP, ModelAndView modelAndView){
        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+isVIP);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }

    //功能1: 默认支持ServletAPI
    @RequestMapping("gotoParams")
    public ModelAndView gotoParams(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelAndView modelAndView){
        //获取请求参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        //封装数据
        modelAndView.addObject("nowDate", new Date()+"===="+id+"==="+name);
        //指定页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
