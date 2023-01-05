package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username = #{userName} and password = #{userPassward}")
    User userLogin(User user);
}