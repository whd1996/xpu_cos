package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.Invoice;

import java.util.ArrayList;

public interface InvoiceService extends IService<Invoice> {



    ArrayList<Invoice> selectUserAllInvoiceByUserID(Integer id);
}

