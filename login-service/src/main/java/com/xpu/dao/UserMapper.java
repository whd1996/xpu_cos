package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select(" select id,user_Name,user_Passward,nickName,user_phone,address,role_ID from user " +
            "where user_Name=#{userName} and user_Passward = #{userPassward}")
    User userLogin(User user);
}