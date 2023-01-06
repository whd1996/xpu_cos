package com.xpu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.UserMapper;
import com.xpu.entity.User;
import com.xpu.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Resource
    UserMapper userMapper;
    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }
}