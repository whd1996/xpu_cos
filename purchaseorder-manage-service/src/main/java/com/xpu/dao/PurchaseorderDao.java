package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Purchaseorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface PurchaseorderDao extends BaseMapper<Purchaseorder> {
    @Select("select purchaseorder.id,purchaseorder.commodity_ID,purchaseorder.add_Amount from purchaseorder")
    ArrayList<Purchaseorder> selectAllPurchaseorder();
}