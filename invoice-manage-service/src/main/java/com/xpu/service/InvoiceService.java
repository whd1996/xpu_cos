package com.xpu.service;

import com.xpu.entity.Invoice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.HashMap;

public interface InvoiceService extends IService<Invoice>{


    int addInvoice(Invoice invoice);

    Invoice selectInvoiceById(Integer id);

    int delete(Integer id);

    int updateInvoice(Invoice invoice);

    ArrayList<Invoice> selectALLInvoice();

    ArrayList<HashMap<String, Object>> selectALLInvoiceInfo();

    ArrayList<HashMap<String, Object>> selectUserAllInvoiceInfoByUserId(Integer id);
}
