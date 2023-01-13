package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Purchaseorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface PurchaseorderDao extends BaseMapper<Purchaseorder> {
    @Select("select purchaseorder.id,purchaseorder.commodity_ID,purchaseorder." +
            "add_Amount from purchaseorder")
    ArrayList<Purchaseorder> selectAllPurchaseorder();

    @Select("SELECT  p.id, c.commodity_Name 采购商品,p.add_Amount 采购数量,c.commodity_price *" +
            " p.add_Amount 花费金额   FROM  purchaseorder p," +
            "commodity c WHERE p.commodity_ID =c.id;")
    ArrayList<HashMap<String, Object>> selectPurchaseRecords();
}