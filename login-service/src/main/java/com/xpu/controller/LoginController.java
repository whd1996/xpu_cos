package com.xpu.controller;

import com.alibaba.fastjson.JSON;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserService  us;
    @RequestMapping ("/login")
    @ResponseBody
    public String login(@RequestBody User user, HttpServletRequest req, HashMap<String,String> map){
        System.out.println("前台： "+user);
        User loginuser=us.userLogin(user);
        System.out.println("dao查到的： "+loginuser);
        req.getSession().setAttribute("user",loginuser);
        req.getSession().setAttribute("isLogin",true);
        if(loginuser!=null)
            map.put("msg","登录成功");
        else
            map.put("msg","登录失败");
        map.remove("org.springframework.validation.BindingResult.user");
        return JSON.toJSONString(map);
    }
    @RequestMapping ("/loginByAnnotation")
    public void loginByAnnotation(@RequestBody User user, HttpServletRequest req){
        System.out.println(user);
        Integer id = us.loginByAnnotation(user);
        System.out.println("登录者的id是"+id);
    }
}
