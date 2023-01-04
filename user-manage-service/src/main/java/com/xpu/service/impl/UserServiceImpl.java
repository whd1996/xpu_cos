package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.UserDao;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    UserDao userDao;
    @Override
    public int insertUser(User record) {
        return userDao.insert(record);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.deleteById(id)>0?true:false;
    }
}
