package com.xpu.controller;

import com.xpu.entity.Invoice;
import com.xpu.entity.R;
import com.xpu.service.InvoiceService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Api(tags = "发票管理接口")
@RequestMapping("/invoice")
public class InvoiceController {
    @Resource
    InvoiceService invoiceService;

    @ResponseBody
    @GetMapping("/selectUserAllInvoiceInfoByUserId")
    public R selectUserAllInvoiceInfoByUserId(Integer id) {
        ArrayList<HashMap<String, Object>> invoiceInfoList = invoiceService.selectUserAllInvoiceInfoByUserId(id);
        boolean flag = (!invoiceInfoList.isEmpty());
        return new R(true, invoiceInfoList, flag ? "查询成功" : "无发票详细信息");
    }

    @ResponseBody
    @GetMapping("/selectALLInvoice")
    public R selectALLInvoice() {
        ArrayList<Invoice> invoiceList = invoiceService.selectALLInvoice();
        boolean flag = (!invoiceList.isEmpty());
        return new R(true, invoiceList, flag ? "查询成功" : "无商品信息");
    }
    @ResponseBody
    @GetMapping("/selectALLInvoiceInfo")
    public R selectALLInvoiceInfo() {
        ArrayList<HashMap<String, Object>> invoiceList = invoiceService.selectALLInvoiceInfo();
        boolean flag = (!invoiceList.isEmpty());
        return new R(true, invoiceList, flag ? "查询成功" : "无商品信息");
    }

           /*   @PostMapping("/addInvoice")
       @ResponseBody
       public R addInvoice(@RequestBody Invoice invoice) {
           int count = invoiceService.addInvoice(invoice);
           boolean flag = count > 0;
           return new R(flag, String.valueOf(count));
       }
   */
    /*   @ResponseBody
       @GetMapping("/deleteInvoiceById")
       public R deleteInvoiceById(Integer id) {
           System.out.println("前台：InvoiceId是" + id);
           boolean flag = invoiceService.delete(id)>0;
           return new R(flag, flag ? "删除成功" : "删除失败");
       }*/
    /*  @ResponseBody
      @PostMapping("/updateInvoice")
      public R updateInvoiceById(@RequestBody Invoice invoice) {
          int count = invoiceService.updateInvoice(invoice);
          boolean flag = (count > 0);
          return new R(flag, flag ? "更新成功！" : "更新失败！");
      }*/
    /*
    @GetMapping("/selectInvoiceById")
    @ResponseBody
    public R selectInvoiceById(Integer id) {
        Invoice invoice = invoiceService.selectInvoiceById(id);
        boolean flag = (invoice != null);
        return new R(flag, invoice, flag ? "查询成功！" : "查询失败！");
    }

    @ResponseBody
    @GetMapping("/selectALLInvoiceInfo")
    public R selectALLInvoiceInfo() {
        ArrayList<HashMap<String,Object>> invoiceInfoList = invoiceService.selectALLInvoiceInfo();
        boolean flag = (!invoiceInfoList.isEmpty());
        return new R(true, invoiceInfoList, flag ? "查询成功" : "无发票详细信息");
    }
*/

}
