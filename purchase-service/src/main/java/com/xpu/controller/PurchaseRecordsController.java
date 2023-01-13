package com.xpu.controller;

import com.xpu.entity.R;
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
import java.util.ArrayList;
import java.util.HashMap;

@Api(tags = "采购记录查询接口")
@Controller
@RequestMapping("/purchase")
public class PurchaseRecordsController {
    @Resource
    CommodityService commodityService;
    @Resource
    PurchaseorderService purchaseorderService;

    @ResponseBody

    @ApiOperation(value = "采购记录展示", notes = "采购记录展示：\n参数：无" +
            "参数类型为 采购商品的id,采购数量num")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    @GetMapping("selectPurchaseRecords")
    public R selectPurchaseRecords() {
        ArrayList<HashMap<String, Object>> list = purchaseorderService.selectPurchaseRecords();
        return new R(true, list, list.isEmpty() ? "无内容" : "查询成功");

    }
}
