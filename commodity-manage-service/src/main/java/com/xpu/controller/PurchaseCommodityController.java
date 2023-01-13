package com.xpu.controller;

import com.xpu.entity.Admin;
import com.xpu.entity.Commodity;
import com.xpu.entity.R;
import com.xpu.entity.User;
import com.xpu.service.CommodityService;
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
@Api(tags = "需采购商品的展示")
@RequestMapping("/commodity")
public class PurchaseCommodityController {
    @Resource
    CommodityService commodityService;

    @ResponseBody
    @GetMapping("/selectPurchaseCommodity")
    @ApiOperation(value = "需采购商品展示接口", notes = "需采购商品展示接口说明:\n参数:无")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectPurchaseCommodity(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if(user!=null){

            if(user.getRoleId()==0)
                return new R(false, "登录者不是采购员");
            ArrayList<Commodity> commodityList = commodityService.selectPurchaseCommodity();
            boolean flag = !commodityList.isEmpty();
            return new R(flag, commodityList, flag ? "查询成功" : "没有需要采购的商品");
        }else if(admin!=null){
            return new R(false, "管理员"+admin.getName()+"您好,请联系采购员");
        }
        return new R(false, "登录已失效");
    }

}
