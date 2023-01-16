package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.Admin;

public interface AdminService extends IService<Admin>{


    Admin adminLogin(Admin admin);
}
