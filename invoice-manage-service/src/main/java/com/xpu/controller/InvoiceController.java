package com.xpu.controller;

import com.xpu.entity.Invoice;
import com.xpu.entity.R;
import com.xpu.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class InvoiceController {
    @Resource
    InvoiceService invoiceService;

    @PostMapping("/addInvoice")
    @ResponseBody
    public R addInvoice(@RequestBody Invoice invoice) {
        int count = invoiceService.addInvoice(invoice);
        boolean flag = count > 0;
        return new R(flag, String.valueOf(count));
    }

    @ResponseBody
    @GetMapping("/deleteInvoiceById")
    public R deleteInvoiceById(Integer id) {
        System.out.println("前台：InvoiceId是" + id);
        boolean flag = invoiceService.delete(id);
        return new R(flag, flag ? "删除成功" : "删除失败");
    }

    @GetMapping("/selectInvoiceById")
    @ResponseBody
    public R selectInvoiceById(Integer id) {
        Invoice invoice = invoiceService.selectInvoiceById(id);
        boolean flag = (invoice != null);
        return new R(flag, invoice, flag ? "查询成功！" : "查询失败！");
    }

    @ResponseBody
    @PostMapping("/updateInvoice")
    public R updateInvoiceById(@RequestBody Invoice invoice) {
        int count = invoiceService.updateInvoice(invoice);
        boolean flag = (count > 0);
        return new R(flag, flag ? "更新成功！" : "更新失败！");
    }
}
