package com.xpu.service.impl;

import com.xpu.entity.Admin;
import com.xpu.entity.LoginUser;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.AdminService;
import com.xpu.service.LoginService;
import com.xpu.service.UserService;
import com.xpu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author whd
 * @version 1.0.0
 * @date 2023/08/27 12:21:38
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpServletRequest req;
    @Override
    public R login(LoginUser loginUser) {
        int flag=loginUser.getFlag();
        String username= loginUser.getUser().getUsername();
        String password=loginUser.getUser().getPassword();
        if (flag == 1) {
            User user=new User();
            user.setUserName(username);
            user.setUserPassward(MD5Utils.getMD5(password));
            User loginuser = userService.userLogin(user);
            if (loginuser != null) {
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
            admin.setAdminName(username);
            admin.setAdminPassword(password);
            Admin loginAdmin = adminService.adminLogin(admin);
            if (loginAdmin != null) {
                req.getSession().setAttribute("admin", loginAdmin);
                req.getSession().setAttribute("isLogin", true);
                return new R(true, loginAdmin, "管理员登录成功");
            }
        }
        return new R("登录失败");
    }

    @Override
    public R userRegister(User user) {
        //查询一下 用户名有没有被注册
        User webUser = userService.selectUserByUserName(user.getUserName());
        if (webUser != null)
            return new R(false, "用户名已被注册");
        user.setUserPassward(MD5Utils.getMD5(user.getUserPassward()));
        boolean flag = userService.userRegister(user);
        return new R(flag, user, flag ? "注册成功" : "注册失败");
    }
}
