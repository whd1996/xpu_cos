package com.xpu.controller;

import com.xpu.entity.Invoice;
import com.xpu.entity.Orderform;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.CommodityService;
import com.xpu.service.InvoiceService;
import com.xpu.service.OrderformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "购买服务接口")
@Controller
@RequestMapping("buy")
public class BuyController{
    @Resource
    CommodityService commodityService;
    @Resource
    OrderformService orderformService;
    @Resource
    InvoiceService invoiceService;

    @ResponseBody
    @ApiOperation(value = "购买商品", notes = "购买商品接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    @GetMapping("buyCommodity")
    public R buyCommodity( int id,int num,double price, HttpServletRequest req){
        User loginuser = (User) req.getSession().getAttribute("user");
        System.out.println(id);
        System.out.println(loginuser);
        Orderform order = new Orderform();
        if(loginuser!=null){
            order.setUserId(loginuser.getId());
            order.setCommodityId(id);
            order.setCommodityAmount(num);
            order.setOrderformPrice(price);
            System.out.println(order);
            //新增订单
            int count=orderformService.addOrder(order);
            //减少库存数量
        }

        return new R("用户未登录");
    }
}
