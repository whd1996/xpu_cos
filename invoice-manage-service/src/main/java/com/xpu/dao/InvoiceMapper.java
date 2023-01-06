package com.xpu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Invoice;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.ArrayList;

@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {

    @Select("select id,user_ID,commodity_ID,invoice_Date,orderForm_ID,invoice_Drawer from invoice")
    ArrayList<Invoice> selectALLInvoice();
}