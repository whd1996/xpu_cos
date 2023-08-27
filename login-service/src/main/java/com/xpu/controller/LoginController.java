package com.xpu.controller;

import com.xpu.entity.LoginUser;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户登录管理")
@Controller
@RequestMapping("/user")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private HttpServletRequest request;

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录接口", notes = "登录接口的说明")

    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R login(@RequestBody LoginUser loginUser) {
        log.info("用户登录: loginUser=>{}", loginUser);
        return loginService.login(loginUser);
    }

    @PostMapping("/register")
    @ResponseBody
    @ApiOperation(value = "注册接口", notes = "注册需要除id外的字段必填")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R register(@RequestBody User user) {
        log.info("用户注册: user=>{}", user);
        return loginService.userRegister(user);
    }

    @GetMapping("logout")
    @ResponseBody
    @ApiOperation(value = "退出登录接口", notes = "清空session后退出")
    public R logout() {
        log.info("退出登录");
        request.getSession().invalidate();//清空session 返回登录页
        return new R(true, "退出登录成功");
    }


}
