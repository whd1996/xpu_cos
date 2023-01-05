package com.xpu.service;

import com.xpu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User>{


    User userLogin(User user);
}
