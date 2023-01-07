package com.xpu.controller;

import com.xpu.entity.Admin;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.AdminService;
import com.xpu.service.UserService;
import com.xpu.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Api(tags = "用户登录管理")
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录接口", notes = "登录接口的说明,参数类型如\n" +
            "{\n" +
            "    \"flag\" :1,\n" +
            "    \"user\":{   \n" +
            "    \"username\": \"abc\",\n" +
            "    \"password\": \"123456\"\n" +
            "    }\n" +
            "}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R login(@RequestBody HashMap<String, Object> map,HttpServletRequest req) {
        System.out.println(map);
        int flag = (int) map.get("flag");
        HashMap userMap = (HashMap) map.get("user");
        User user = new User();
        user.setUserName((String) userMap.get("username"));
        user.setUserPassward((String) userMap.get("password"));
        if (flag == 1) {
            user.setUserPassward(MD5Utils.getMD5(user.getUserPassward()));
            User loginuser = userService.userLogin(user);
            if (loginuser != null) {
                System.out.println("dao查到的： " + loginuser);
                HttpSession session = req.getSession();
                session.setAttribute("user", loginuser);
                session.setAttribute("isLogin", true);
                if (loginuser.getRoleId() == 1)
                    return new R(true, loginuser, "采购员登录成功");
                else
                    return new R(true, loginuser, "客户登录成功");
            }
        } else if (flag==0) {
            //管理登录业务
            Admin admin = new Admin();
            admin.setAdminName((String) userMap.get("username"));
            admin.setAdminPassword((String) userMap.get("password"));
            HttpSession session = req.getSession();
            Admin loginAdmin = adminService.adminLogin(admin);
            if (loginAdmin != null) {
                session.setAttribute("admin", loginAdmin);
                req.getSession().setAttribute("isLogin", true);
                return new R(true, loginAdmin, "管理员登录成功");
            }
        }
        return new R("登录失败");
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
        user.setUserPassward(MD5Utils.getMD5(user.getUserPassward()));
        boolean flag = userService.userRegister(user);
        return new R(flag,user,flag ? "注册成功" : "注册失败");
    }

    @GetMapping("logout")
    @ResponseBody
    @ApiOperation(value = "退出登录接口", notes = "清空session后退出")
    public R logout(HttpServletRequest req) {
        req.getSession().invalidate();//清空session 返回登录页
        return new R(true,"退出登录成功");
    }


}
