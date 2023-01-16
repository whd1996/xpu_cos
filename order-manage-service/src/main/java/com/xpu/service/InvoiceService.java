package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.Invoice;

public interface InvoiceService extends IService<Invoice> {

    Invoice selectInvoiceByOrderId(Integer oid);
}

