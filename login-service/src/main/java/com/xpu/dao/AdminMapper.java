package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin where admin_Name = #{adminName} and admin_Password = #{adminPassword}")
    Admin adminLogin(Admin admin);
}