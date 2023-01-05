package com.xpu.controller;

import com.xpu.entity.Orderform;
import com.xpu.entity.R;
import com.xpu.service.OrderformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@Controller
@Api(tags = "订单管理")
public class OrderController {
    @Resource
    OrderformService orderformService;

    @ResponseBody
    @PostMapping("/addOrder")
    @ApiOperation(value = "订单接口", notes = "订单接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R addOrder (@RequestBody Orderform orderform){

        System.out.println(orderform);
        int count = orderformService.addOrder(orderform);
        boolean flag=count>0;
        return new R(flag,flag?"插入成功":"插入失败");
    }
}
