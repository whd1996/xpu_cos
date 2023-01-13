package com.xpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.InvoiceDao;
import com.xpu.entity.Invoice;
import com.xpu.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceDao, Invoice> implements InvoiceService {
    @Resource
    InvoiceDao invoiceDao;


    /**
     * @param id 发票表中的订单id
     * @return Invoice实体
     */
    @Override
    public Invoice selectInvoiceByUserId(Integer id) {
        QueryWrapper<Invoice> qw = new QueryWrapper<>();
        qw.eq("userForm_ID", id );
        return invoiceDao.selectOne(qw);
    }
}

