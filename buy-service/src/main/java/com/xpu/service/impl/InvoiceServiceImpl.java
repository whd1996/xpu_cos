package com.xpu.service.impl;

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

    @Override
    public int addInvoice(Invoice invoice) {
        return invoiceDao.insert(invoice);
    }
}

