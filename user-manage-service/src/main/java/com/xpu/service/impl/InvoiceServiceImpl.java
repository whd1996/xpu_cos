package com.xpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.InvoiceDao;
import com.xpu.entity.Invoice;
import com.xpu.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceDao, Invoice> implements InvoiceService {
    @Resource
    InvoiceDao invoiceDao;


    /**
     * @param uid 发票表中的用户id 数据库字段为user_ID
     * @return Invoice实体
     */
    @Override
    public ArrayList<Invoice> selectUserAllInvoiceByUserID(Integer uid) {
        QueryWrapper<Invoice> qw = new QueryWrapper<>();
        qw.eq("user_ID", uid );
        return (ArrayList<Invoice>) invoiceDao.selectList(qw);
    }
}

