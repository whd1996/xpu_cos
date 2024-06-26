package com.xpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.UserMapper;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Resource
    UserMapper userMapper;
    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public boolean userRegister(User user) {
        return userMapper.insert(user)>0;
    }

    @Override
    public User selectUserByUserName(String userName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name",userName);
        return userMapper.selectOne(qw);
    }
}
