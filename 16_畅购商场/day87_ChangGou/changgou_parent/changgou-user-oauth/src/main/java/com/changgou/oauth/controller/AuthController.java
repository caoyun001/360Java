package com.changgou.oauth.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.oauth.service.AuthService;
import com.changgou.oauth.util.AuthToken;
import com.changgou.oauth.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private Integer cookieMaxAge;

    @GetMapping("/toLogin")
    public String toLogin(@RequestParam(value = "ReturnUrl",required = false, defaultValue = "http://www.changgou.com")String ReturnUrl, Model model){
        model.addAttribute("ReturnUrl", ReturnUrl);
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam(value = "ReturnUrl",required = false, defaultValue = "http://www.changgou.com")String ReturnUrl){
        try {
            AuthToken authToken = authService.applyToken(clientId, clientSecret, username, password);
            saveJtiToCookie(authToken.getJti());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:"+ ReturnUrl;
    }


    @PostMapping("/interface/login")
    @ResponseBody
    public Result interfaceLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        try {
            AuthToken authToken = authService.applyToken(clientId, clientSecret, username, password);
            saveJtiToCookie(authToken.getJti());
            return new Result(true, StatusCode.OK, "登录成功！", authToken);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, StatusCode.LOGINERROR, "登录失败！");
        }

    }

    private void saveJtiToCookie(String jti){
        ServletRequestAttributes servletRequestAttributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        CookieUtil.addCookie(response, cookieDomain, "/", "uid", jti, cookieMaxAge, false);
    }
}
