package com.xpu.service;

import com.xpu.entity.User;

public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User userLogin(User user);

    Integer loginByAnnotation(User user);
}




