package com.xpu.controller;


import com.xpu.entity.*;
import com.xpu.service.InvoiceService;
import com.xpu.service.OrderformService;
import com.xpu.service.UserService;
import com.xpu.utils.MD5Utils;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Api(tags = "用户管理")
@Controller
@RequestMapping("/userinfo")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    OrderformService orderformService;
    @Resource
    InvoiceService invoiceService;
    @ResponseBody
    @PostMapping("/addUser")
    public R addUser(@RequestBody User user) {
        User  webUser=userService.selectUserByUserName(user.getUserName());
        if(webUser!=null)
            return new R(false,"用户名已被注册");
        System.out.println("前台：user" + user);
        user.setUserPassward(MD5Utils.getMD5(user.getUserPassward()));
        int count = userService.insertUser(user);
        System.out.println(count);
        boolean flag = count > 0;
        return new R(flag, String.valueOf(count));
    }

    @ResponseBody
    @GetMapping("/deleteUserById")
    public R deleteUserById(Integer uid, HttpServletRequest req) {
        System.out.println("前端id是:"+uid);
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if(admin==null)
            return new R(false, "管理未登录！");
        User user = userService.selectUserById(uid);
        if (user == null)
            return new R(false, "无该用户");
        ArrayList<Orderform> orderList = orderformService.selectUserAllOrderByUserId(uid);
        if (orderList.isEmpty())
            System.out.println("该用户无订单！");
        //查询与该用户相关的所有发票信息
        ArrayList<Invoice> invoiceList = invoiceService.selectUserAllInvoiceByUserID(uid);
        if (invoiceList.isEmpty())
            System.out.println("该用户无发票！");
        //删除这些发票信息与订单信息
        //删除该用户所有发票信息
        for (Invoice inv : invoiceList)
            invoiceService.removeById(inv.getId());
        //删除该用户所有相关订单信息
        for (Orderform ord : orderList)
            orderformService.deleteOrderById(ord.getId());
        //删除用户信息
        boolean deleteSuccess = userService.delete(uid);
        return new R(deleteSuccess, deleteSuccess ? "删除成功" : "删除失败");
    }

    @ResponseBody
    @GetMapping("/selectUserById")
    public R selectUserById(Integer id) {
        User user = userService.selectUserById(id);
        boolean flag = (user != null);
        return new R(flag, user, flag ? "查询成功！" : "无该用户！");
    }
    @ResponseBody
    @GetMapping("/selectUserByUserName")
    public R selectUserByUserName(String username) {
        User user = userService.selectUserByUserName(username);
        boolean flag = (user != null);
        return new R(flag, user, flag ? "查询成功！" : "无该用户！");
    }

    @ResponseBody
    @GetMapping("/selectALLUser")
    public R selectALLUser() {
        ArrayList<User> userList = userService.selectALLUser();
        boolean flag =!userList.isEmpty();
        return new R(flag,userList,flag?"查询成功":"无内容");
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
