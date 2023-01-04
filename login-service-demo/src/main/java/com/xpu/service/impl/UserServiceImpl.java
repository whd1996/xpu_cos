package com.xpu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xpu.dao.UserMapper;
import com.xpu.entity.User;
import com.xpu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public Integer loginByAnnotation(User user) {
        return userMapper.login(user);
    }

}





