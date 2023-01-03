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
    public String login(User user, HttpServletRequest req){
        System.out.println(user);
        User loginuser=us.userLogin(user);
        req.getSession().setAttribute("user",loginuser);
        HashMap<String,String> map =new HashMap<>();
        if(loginuser!=null)
            map.put("msg","登录成功");
        else
            map.put("msg","登录失败");
        return JSON.toJSONString(map);
    }
    @RequestMapping ("/loginByAnnotation")
    public void loginByAnnotation(@RequestBody User user, HttpServletRequest req){
        System.out.println(user);
        Integer id = us.loginByAnnotation(user);
        System.out.println("登录者的id是"+id);
    }
}
