package com.xpu.service;

import com.xpu.entity.Invoice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

public interface InvoiceService extends IService<Invoice>{


    int addInvoice(Invoice invoice);

    Invoice selectInvoiceById(Integer id);

    boolean delete(Integer id);

    int updateInvoice(Invoice invoice);

    ArrayList<Invoice> selectALLInvoice();
}
