package com.xpu.controller;

import com.alibaba.fastjson.JSON;
import com.xpu.entity.Commodity;
import com.xpu.entity.Purchaseorder;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.CommodityService;
import com.xpu.service.PurchaseorderService;
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
import java.util.HashMap;

@Api(tags = "采购服务接口")
@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Resource
    CommodityService commodityService;
    @Resource
    PurchaseorderService purchaseorderService;

    @ResponseBody

    @ApiOperation(value = "采购商品", notes = "采购商品接口的说明\n" +
            "参数类型为 采购商品的id,采购数量num")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    @GetMapping("purchaseCommodity")
    public R buyCommodity(int id, int num, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            if (user.getRoleId() != 1)
                return new R(false, "登录者不是采购员");
            Commodity good = commodityService.selectCommodityById(id);
            if (good == null)
                return new R(false, "无该id的商品");
            if (num <= 0)
                return new R(false, "商品数量输入有误！");
            Purchaseorder purchaseorder = new Purchaseorder();
            purchaseorder.setCommodityId(id);
            purchaseorder.setAddAmount(num);
            //新增采购订单
            boolean flag1 = purchaseorderService.addPurchaseorder(purchaseorder) > 0;
            good.setCommodityRepertory(good.getCommodityRepertory() + num);
            //修改商品数量
            boolean flag2 = commodityService.updateCommodity(good);
            //计算消费金额cost
            Double cost=good.getCommodityPrice() * num;
            if (flag1&&flag2){
                HashMap<String, Object> map = new HashMap<>();
                map.put("cost",cost);
                map.put("good",good);
                map.put("purchaseorder",purchaseorder);
                return new R(true, JSON.toJSON(map),"采购成功");
            }else
                return new R(false, "采购失败");


        }
        return new R(false, "用户未登录");
    }
}
