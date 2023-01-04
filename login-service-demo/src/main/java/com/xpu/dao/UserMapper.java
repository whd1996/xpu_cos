package com.xpu.dao;

import com.xpu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //xml形式登录
    User userLogin(User user);

    //注解形式登录
    @Select("select id from user where username = #{username} and password = #{password}")
    Integer login(User login);
}