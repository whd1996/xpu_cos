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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Api(tags = "用户登录管理")
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    UserService us;
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登录接口", notes = "登录接口的说明,参数类型如 {\n" +
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
        int flag = (int) map.get("flag");
        HashMap userMap = (HashMap) map.get("user");
        User user = new User();
        user.setUserName((String) userMap.get("username"));
        user.setUserPassward((String) userMap.get("password"));
        if (flag == 1) {
            user.setUserPassward(MD5Utils.getMD5(user.getUserPassward()));
            User loginuser = us.userLogin(user);
            System.out.println("dao查到的： " + loginuser);
            HttpSession session = req.getSession();
            session.setAttribute("user", loginuser);
            req.getSession().setAttribute("isLogin", true);
            boolean loginFlag = (loginuser != null);
            return new R(loginFlag, loginuser, loginFlag ? "用户登录成功" : "用户登录失败");
        } else if (flag==0) {
            //管理登录业务
           Admin admin= new Admin();
           admin.setAdminName((String) userMap.get("username"));
           admin.setAdminPassword((String) userMap.get("password"));
            HttpSession session = req.getSession();
             Admin loginAdmin =adminService.adminLogin(admin);
            session.setAttribute("user", loginAdmin);
            req.getSession().setAttribute("isLogin", true);
            boolean loginFlag = (loginAdmin != null);
            return new R(loginFlag, loginAdmin, loginFlag ? "管理员登录成功" : "管理员登录失败");
        }
        return  new R("登录失败");
    }

}
