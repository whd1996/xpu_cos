package com.xpu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.UserDao;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public int insertUser(User record) {
        return userDao.insert(record);
    }

    // 删除方法
    @Override
    public boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public User selectUserById(Integer id) {

        return userDao.selectById(id);
    }


    @Override
    public int updateUser(User user) {
        return userDao.updateById(user);
    }

    @Override
    public ArrayList<User> selectALLUser() {
        return userDao.selectALLUser();
    }

    @Override
    public User selectUserByUserName(String userName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name",userName);
        return userDao.selectOne(qw);
    }

}
