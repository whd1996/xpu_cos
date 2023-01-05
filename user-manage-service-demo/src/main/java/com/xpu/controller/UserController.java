package com.xpu.controller;

import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import com.xpu.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Resource
    UserService userService;
    @ResponseBody
    @PostMapping("/addUser")
    public R addUser(@RequestBody User user){
        System.out.println("前台：user"+user);
        user.setPassword(MD5Utils.getMD5(user.getPassword()));
        int count = userService.insertUser(user);
        System.out.println(count);
        boolean flag =(count>0)?true:false;
        return  new R(flag,String.valueOf(count));
    }
    @ResponseBody
    @GetMapping("/deleteUserById")
    public R deleteUserById(Integer id){
        System.out.println("前台：userId是"+id);
        boolean flag = userService.delete(id);
        return  new R(flag,flag?"删除成功":"删除失败");
    }
    @ResponseBody
    @GetMapping("/selectUserById")
    public R selectUserById(Integer id, HttpServletRequest req){
        User user1 = (User) req.getSession().getAttribute("user");
        System.out.println("当前登录的是："+user1);
        System.out.println("前台：userId是"+id);
        User user = userService.selectUserById(id);
        boolean flag=(user!=null);
        return  new R(flag,user,flag?"查询成功！":"无该用户！");
    }
    @ResponseBody
    @PostMapping ("/updateUser")
    public R updateUserByID( @RequestBody User user){
        int count = userService.updateUser(user);
        boolean flag=(count>0);
        return  new R(flag,flag?"更新成功！":"更新失败！");
    }
}
