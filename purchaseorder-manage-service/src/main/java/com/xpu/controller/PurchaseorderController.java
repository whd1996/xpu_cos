package com.xpu.controller;

import com.xpu.entity.R;
import com.xpu.service.PurchaseorderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Api(tags = "采购订单管理")
@RequestMapping("/purchaseorder")
public class PurchaseorderController {
    @Resource
    PurchaseorderService purchaseorderService;


    @ResponseBody
    @GetMapping("/selectPurchaseorderInfoById")
    @ApiOperation(value = "根据id查询采购订单详情", notes = "根据id查询采购订单详情\n" +
            "响应数据详情：\n" +
            "{\n" +
            "  \"flag\": true,\n" +
            "  \"data\": {\n" +
            "    \"商品名称\": \"苹果\",\n" +
            "    \"采购数量\": 10,\n" +
            "    \"id\": 22,\n" +
            "    \"是否上架\": \"是\",\n" +
            "    \"商品库存\": 113\n" +
            "  },\n" +
            "  \"msg\": \"查询成功\"\n" +
            "}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectPurchaseorderInfoById(Integer pid) {
        HashMap <String,Object> purchaseorderMap= purchaseorderService.selectPurchaseorderInfoById(pid);
        boolean flag = (purchaseorderMap!=null);
        return new R(flag,purchaseorderMap,flag ? "查询成功" : "查询失败");
    }

    @ResponseBody
    @GetMapping("/deletePurchaseorderById")
    @ApiOperation(value = "采购订单删除接口", notes = "采购订单删除接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R deletePurchaseorderById(Integer id) {
        int count = purchaseorderService.deletePurchaseorderById(id);
        boolean flag = (count > 0);
        return new R(flag,flag?"删除成功" : "删除失败");
    }

    @ResponseBody
    @GetMapping("/selectAllPurchaseorderInfo")
    @ApiOperation(value = "全部采购订单详情查询接口", notes = "所有采购订单详情查询接口说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectAllPurchaseorderInfo( ) {

        ArrayList<HashMap <String,Object>> orderList = purchaseorderService.selectAllPurchaseorderInfo();

        return new R(true,orderList,orderList.isEmpty()?"无内容":"查询成功");
    }

/* @ResponseBody
    @PostMapping("/addPurchaseorder")
    @ApiOperation(value = "采购订单新增接口", notes = "采购订单新增接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R addPurchaseorder(@RequestBody Purchaseorder purchaseorder) {

        System.out.println(purchaseorder);
        int count = purchaseorderService.addPurchaseorder(purchaseorder);
        boolean flag = count > 0;
        return new R(flag, flag ? "插入成功" : "插入失败");
    }*/

/*    @ResponseBody
    @GetMapping("/selectPurchaseorderById")
    @ApiOperation(value = "根据id查询采购订单", notes = "根据id查询采购订单")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectPurchaseorderById(Integer id) {
        Purchaseorder purchaseorder = purchaseorderService.selectPurchaseorderById(id);
        boolean flag = (purchaseorder != null);
        return new R(flag,purchaseorder,flag ? "查询成功" : "查询失败");
    }*/
    /*    @ResponseBody
    @GetMapping("/selectAllPurchaseorder")
    @ApiOperation(value = "全部采购订单查询接口", notes = "所有采购订单查询接口")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public String selectAllPurchaseorder( ) {

        ArrayList<Purchaseorder> orderList = purchaseorderService.selectAllPurchaseorder();

        return JSON.toJSONString(orderList);
    }*/
        /*@GetMapping("/updatePurchaseorderById")
    @ResponseBody
    @ApiOperation(value = "采购订单修改接口", notes = "采购订单修改接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R updatePurchaseorderById(Purchaseorder purchaseorder) {
        int count = purchaseorderService.updatePurchaseorderById(purchaseorder);
        boolean flag = (count > 0);
        return new R(flag,flag?"修改成功" : "修改失败");
    }*/
}
