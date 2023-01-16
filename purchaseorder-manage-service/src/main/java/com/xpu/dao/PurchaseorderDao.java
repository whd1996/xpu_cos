package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Purchaseorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface PurchaseorderDao extends BaseMapper<Purchaseorder> {
    @Select("select purchaseorder.id,purchaseorder.commodity_ID,purchaseorder.add_Amount from purchaseorder")
    ArrayList<Purchaseorder> selectAllPurchaseorder();

    @Select("SELECT\n" +
            "\tp.id,\n" +
            "\tc.commodity_Name 商品名称,\n" +
            "IF\n" +
            "\t( c.upOrDown = 1, '是', '否' ) 是否上架,\n" +
            "\tp.add_Amount 采购数量,\n" +
            "\tc.commodity_repertory 商品库存 \n" +
            "FROM\n" +
            "\tpurchaseorder p,\n" +
            "\tcommodity c \n" +
            "WHERE\n" +
            "\tp.commodity_ID = c.id \n" +
            "\tAND p.id = #{pid}")
    HashMap<String, Object> selectPurchaseorderInfoById(Integer pid);

    @Select("SELECT\n" +
            "\tp.id,\n" +
            "\tc.commodity_Name 商品名称,\n" +
            "IF\n" +
            "\t( c.upOrDown = 1, '是', '否' ) 是否上架,\n" +
            "\tp.add_Amount 采购数量,\n" +
            "\tc.commodity_repertory 商品库存 \n" +
            "FROM\n" +
            "\tpurchaseorder p\n" +
            "\tLEFT JOIN commodity c ON p.commodity_ID = c.id")
    ArrayList<HashMap<String, Object>> selectAllPurchaseorderInfo();
}