package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Orderform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface OrderformDao extends BaseMapper<Orderform> {
    @Select("select * from orderform;")
    ArrayList<Orderform> selectAllOrder();
}