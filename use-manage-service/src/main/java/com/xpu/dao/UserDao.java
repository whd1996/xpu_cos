package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select id,user_Name,user_Passward,nickName,user_phone,address,role_ID from user")
    ArrayList<User> selectALLUser();
}