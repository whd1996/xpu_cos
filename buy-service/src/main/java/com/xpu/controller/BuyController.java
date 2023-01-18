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
import java.util.Date;

@Api(tags = "购买服务接口")
@Controller
@RequestMapping("/buy")
public class BuyController{
    @Resource
    CommodityService commodityService;
    @Resource
    OrderformService orderformService;
    @Resource
    InvoiceService invoiceService;

    @ResponseBody

    @ApiOperation(value = "购买商品", notes = "购买商品接口的说明\n" +
            "参数类型为 购买商品的id,购买数量num")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    @GetMapping("buyCommodity")
    public R buyCommodity(int id, int num, HttpServletRequest req) {
        if(num<=0){
            return new R(false, "输入数量有误");
        }
        User loginuser = (User) req.getSession().getAttribute("user");
        if (loginuser != null) {
            System.out.println("当前客户:" + loginuser.getNickname());
            //根据参数查询商品信息
            Commodity good = commodityService.selectCommodityById(id);
            //减少库存数量
            if (good != null) {
                System.out.println("打算购买" + num + "个" + good.getCommodityName());
                if (good.getCommodityRepertory() < num) {
                    return new R(false, "库存不足,无法购买");
                }
                if (good.getUpordown() < 1)
                    return new R(false, "商品还未上架");
                //新增订单
                Orderform order = new Orderform();
                order.setCommodityId(id);
                order.setUserId(loginuser.getId());
                order.setCommodityAmount(num);
                order.setOrderformPrice(good.getCommodityPrice() * num);
                int count = orderformService.addOrder(order);
                boolean orderAddSuccess = count > 0;
                good.setCommodityRepertory(good.getCommodityRepertory() - num);
                //更新商品信息
                boolean commodityUpdateSuccess = commodityService.updateCommodity(good);
                //开发票
                Invoice invoice = new Invoice();
                invoice.setCommodityId(good.getId());//商品id
                invoice.setInvoiceDate(new Date()); //开票日期
                invoice.setOrderformId(order.getId());//订单id
                invoice.setUserId(loginuser.getId());// 用户id
                invoice.setInvoiceDrawer("XPU");
                int invoiceCount = invoiceService.addInvoice(invoice);

                boolean invoiceAddSuccess = invoiceCount > 0;
                if (commodityUpdateSuccess && invoiceAddSuccess && orderAddSuccess) {
                    return new R(true, commodityService.selectCommodityById(id),"购买成功");
                }

            } else
                return new R(false, "无该商品");

        }

        return new R(false, "用户未登录");
    }
}
