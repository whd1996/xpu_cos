package com.xpu.controller;

import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import com.xpu.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = "用户登录管理")
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserService us;

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录接口", notes = "登录接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R login(@RequestBody User user,HttpServletRequest req) {

            System.out.println("前台： " + user);
            user.setPassword(MD5Utils.getMD5(user.getPassword()));
            User loginuser = us.userLogin(user);
            System.out.println("dao查到的： " + loginuser);
            HttpSession session = req.getSession();
            session.setAttribute("user", loginuser);

            req.getSession().setAttribute("isLogin", true);
            boolean flag1=(loginuser!=null);

            return new R(flag1,loginuser,flag1?"用户登录成功":"登录失败");

    }

    @ApiOperation(value = "注解形式开发的登录接口", notes = "注解形式开发的登录接口的说明")
    @PostMapping("/loginByAnnotation")
    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R loginByAnnotation(@RequestBody User user, HttpServletRequest req) {
        System.out.println("前台："+user);
        Integer id = us.loginByAnnotation(user);
        boolean flag = (id!=null)?true:false;
       return new R(flag,id,"当前登录者id："+id);
    }
}
