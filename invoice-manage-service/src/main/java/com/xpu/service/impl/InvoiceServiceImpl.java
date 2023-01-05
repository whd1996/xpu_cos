package com.xpu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.InvoiceMapper;
import com.xpu.entity.Invoice;
import com.xpu.service.InvoiceService;
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService{

}
