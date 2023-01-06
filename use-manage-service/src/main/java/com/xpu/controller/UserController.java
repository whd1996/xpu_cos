package com.xpu.controller;


import com.alibaba.fastjson.JSON;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import com.xpu.utils.MD5Utils;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@Api(tags = "用户管理")
@Controller
@RequestMapping("/userinfo")
public class UserController {
    @Resource
    UserService userService;

    @ResponseBody
    @PostMapping("/addUser")
    public R addUser(@RequestBody User user) {
        System.out.println("前台：user" + user);
        user.setUserPassward(MD5Utils.getMD5(user.getUserPassward()));
        int count = userService.insertUser(user);
        System.out.println(count);
        boolean flag = (count > 0) ? true : false;
        return new R(flag, String.valueOf(count));
    }

    @ResponseBody
    @GetMapping("/deleteUserById")
    public R deleteUserById(Integer id) {
        System.out.println("前台：userId是" + id);
        boolean flag = userService.delete(id);
        return new R(flag, flag ? "删除成功" : "删除失败");
    }

    @ResponseBody
    @GetMapping("/selectUserById")
    public R selectUserById(Integer id) {
        User user = userService.selectUserById(id);
        boolean flag = (user != null);
        return new R(flag, user, flag ? "查询成功！" : "无该用户！");
    }

    @ResponseBody
    @GetMapping("/selectALLUser")
    public String selectALLUser() {
        ArrayList<User> userList = userService.selectALLUser();

        return JSON.toJSONString(userList);
    }

    @ResponseBody
    @PostMapping("/updateUserById")
    public R updateUserById(@RequestBody User user) {
        System.out.println(user);
        int count = userService.updateUser(user);
        boolean flag = (count > 0);
        return new R(flag, flag ? "更新成功！" : "更新失败！");
    }
}
