package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Invoice;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {

    @Select("select id,user_ID,commodity_ID,invoice_Date,orderForm_ID,invoice_Drawer from invoice")
    ArrayList<Invoice> selectALLInvoice();
    @Select("SELECT\n" +
            "\ti.id 发票编号,\n" +
            "\tu.nickName 客户,\n" +
            "\tc.commodity_Name 商品名称,\n" +
            "\tc.commodity_price 单价,\n" +
            "\to.commodity_Amount 商品数量,\n" +
            "\tc.commodity_price * o.commodity_Amount 花费,\n" +
            "\ti.invoice_Date 日期,\n" +
            "\ti.invoice_Drawer 开票单位\n" +
            "FROM\n" +
            "\tinvoice i,\n" +
            "\tuser u,\n" +
            "\tcommodity c,\n" +
            "\torderform o \n" +
            "WHERE\n" +
            "\ti.commodity_ID = c.id \n" +
            "\tAND i.orderForm_ID = o.id \n" +
            "\tAND i.user_ID = u.id;")
    ArrayList<HashMap<String, Object>> selectALLInvoiceInfo();
}