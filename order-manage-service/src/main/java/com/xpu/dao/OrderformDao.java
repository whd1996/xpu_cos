package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Orderform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface OrderformDao extends BaseMapper<Orderform> {
    @Select("SELECT\n" +
            "\to.id,\n" +
            "\tu.user_Name 用户,\n" +
            "\tc.commodity_Name 商品,\n" +
            "\tc.commodity_price 单价,\n" +
            "\to.commodity_Amount 购买数量,\n" +
            "\to.commodity_Amount * c.commodity_price 消费金额,\n" +
            "\ti.invoice_Date 购买日期 \n" +
            "FROM\n" +
            "\tUSER u,\n" +
            "\tcommodity c,\n" +
            "\tinvoice i,\n" +
            "\torderform o \n" +
            "WHERE\n" +
            "\to.commodity_ID = c.id \n" +
            "\tAND i.orderForm_ID = o.id \n" +
            "\tAND o.user_id = u.id \n" +
            "\tAND o.id = #{oid}")
    HashMap<String, Object> selectOrderInfoById(Integer oid);

    @Select("SELECT\n" +
            "\to.id,\n" +
            "\tu.user_Name 用户,\n" +
            "\tc.commodity_Name 商品,\n" +
            "\tc.commodity_price 单价,\n" +
            "\to.commodity_Amount 购买数量,\n" +
            "\to.commodity_Amount * c.commodity_price 消费金额, \n" +
            "\ti.invoice_Date 购买日期\n" +
            "FROM\n" +
            "\tUSER u,\n" +
            "\tcommodity c,\n" +
            "\tinvoice i,\n" +
            "\torderform o \n" +
            "WHERE\n" +
            "\to.commodity_ID = c.id \n" +
            "\tAND i.orderForm_ID = o.id \n" +
            "\tAND o.user_id = u.id")
    ArrayList<HashMap<String, Object>> selectAllOrder();

    @Select("SELECT\n" +
            "\to.id,\n" +
            "\tu.user_Name 用户,\n" +
            "\tc.commodity_Name 商品,\n" +
            "\tc.commodity_price 单价,\n" +
            "\to.commodity_Amount 购买数量,\n" +
            "\to.commodity_Amount * c.commodity_price 消费金额,\n" +
            "\ti.invoice_Date 购买日期 \n" +
            "FROM\n" +
            "\tUSER u,\n" +
            "\tcommodity c,\n" +
            "\tinvoice i,\n" +
            "\torderform o \n" +
            "WHERE\n" +
            "\to.commodity_ID = c.id \n" +
            "\tAND i.orderForm_ID = o.id \n" +
            "\tAND o.user_id = u.id \n" +
            "\tAND u.id = #{uid}")
    ArrayList<HashMap<String, Object>> selectUserAllOrderInfoByUserId(int uid);

}