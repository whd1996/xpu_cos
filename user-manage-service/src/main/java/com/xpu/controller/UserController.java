package com.xpu.controller;

import com.xpu.entity.Invoice;
import com.xpu.entity.Orderform;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.InvoiceService;
import com.xpu.service.OrderformService;
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
    @Resource
    OrderformService orderformService;
    @Resource
    InvoiceService invoiceService;
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
        User user = userService.selectUserById(id);
        if (user == null)
            return new R(false, "无该用户");

        Orderform order = orderformService.selectOrderById(id);
        if (order == null)
            return new R(false, "用户无该编号的订单！");
        //查询与该用户相关的所有发票信息并删除
        Invoice invoice = invoiceService.selectInvoiceByUserId(id);
        if (invoice == null)
            return new R(false, "查询不到该用户发票信息！");
        //查询与该用户相关的所有订单信息并删除

        boolean deleteSuccess = userService.delete(id);
        //删除相关订单信息
        boolean removeOrderSuccess = orderformService.deleteOrderById(id) > 0;
        //删除相关的发票信息
        boolean removeInvoiceSuccess = invoiceService.removeById(invoice.getId());
        boolean flag = (removeOrderSuccess && removeInvoiceSuccess && deleteSuccess);

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
