package com.xpu.service;

import com.xpu.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
public interface AdminService extends IService<Admin>{


    Admin adminLogin(Admin admin);
}
