package com.xpu.controller;


import com.xpu.entity.*;
import com.xpu.service.CommodityService;
import com.xpu.service.InvoiceService;
import com.xpu.service.OrderformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@Api(tags = "退单管理")
@RequestMapping("/order")
public class RemoveOrderController {
    @Resource
    OrderformService orderformService;
    @Resource
    CommodityService commodityService;
    @Resource
    InvoiceService invoiceService;

    @ResponseBody
    @GetMapping("/deleteOrderById")
    @ApiOperation(value = "用户退单接口", notes = "用户退单接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R removeOrderByUserIdAndOrderId(Integer oid, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            ArrayList<Orderform> orderList = orderformService.selectUserAllOrderByUserId(user.getId());
            if (orderList.isEmpty()) {
                return new R(false, "该用户无订单！");
            }
            //查询要退的订单详情
            Orderform order = orderformService.selectOrderById(oid);
            if (order == null)
                return new R(false, "用户无该编号的订单！");
            //查询退单的商品详情
            Commodity commodity = commodityService.selectCommodityById(order.getCommodityId());
            if (commodity == null)
                return new R(false, "已无该商品！");
            //查询退单的发票详情
            Invoice invoice = invoiceService.selectInvoiceByOrderId(oid);
            if (invoice == null)
                return new R(false, "查询不到发票信息！");
            //修改退单的商品库存
            commodity.setCommodityRepertory(commodity.getCommodityRepertory() + order.getCommodityAmount());
            boolean updateCommoditySuccess = commodityService.updateById(commodity);
            //删除相关的订单信息 用删除缓存，故方法需要自己实现
            boolean removeOrderSuccess = orderformService.deleteOrderById(oid) > 0;
            //删除相关的发票信息
            boolean removeInvoiceSuccess = invoiceService.removeById(invoice.getId());
            boolean flag = (updateCommoditySuccess && removeOrderSuccess && removeInvoiceSuccess);
            return new R(flag, flag ? "退单成功" : "退单失败");
        } else
            return new R(false, "用户未登录！");
    }

}
