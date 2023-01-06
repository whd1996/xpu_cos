package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.InvoiceMapper;
import com.xpu.entity.Invoice;
import com.xpu.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService{

    @Resource
    InvoiceMapper invoiceDao;
    @Override
    public int addInvoice(Invoice invoice) {
        return invoiceDao.insert(invoice);
    }

    @Override
    public Invoice selectInvoiceById(Integer id) {
        return invoiceDao.selectById(id);
    }

    @Override
    public int delete(Integer id) {
        return invoiceDao.deleteById(id);
    }

    @Override
    public int updateInvoice(Invoice invoice) {
        return invoiceDao.updateById(invoice);
    }

    @Override
    public ArrayList<Invoice> selectALLInvoice() {
        return invoiceDao.selectALLInvoice();
    }
}
