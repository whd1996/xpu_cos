package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {

    @Select("select\n" +
            "    c.`commodity_Name`,\n" +
            "    c.commodity_price,\n" +
            "    c.commodity_repertory,\n" +
            "    c.id,\n" +
            "    c.`upOrDown`\n" +
            "from\n" +
            "    commodity c;")
    ArrayList<Commodity> selectALLCommodity();
}