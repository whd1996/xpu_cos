package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.User;

public interface UserService extends IService<User>{


    User userLogin(User user);

    boolean userRegister(User user);
}
