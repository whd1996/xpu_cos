package com.xpu.controller;

import com.alibaba.fastjson.JSON;
import com.xpu.entity.Commodity;
import com.xpu.entity.R;
import com.xpu.sevice.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@Api(tags = "商品管理")
public class CommodityController {
    @Resource
    CommodityService CommodityService;

    @ResponseBody
    @PostMapping("/addCommodity")
    @ApiOperation(value = "商品新增接口", notes = "商品新增接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R addCommodity(@RequestBody Commodity commodity) {

        System.out.println(commodity);
        int count = CommodityService.addCommodity(commodity);
        boolean flag = count > 0;
        return new R(flag, flag ? "插入成功" : "插入失败");
    }


    @ResponseBody
    @GetMapping("/deleteCommodityById")
    @ApiOperation(value = "商品删除接口", notes = "商品删除接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R deleteCommodityById(Integer id) {
        int count = CommodityService.deleteCommodityById(id);
        boolean flag = (count > 0);
        return new R(flag,flag?"删除成功" : "删除失败");
    }



    @ResponseBody
    @GetMapping("/selectCommodityById")
    @ApiOperation(value = "根据id商品查询接口", notes = "根据id商品查询接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectCommodityById(Integer id) {
        Commodity commodity= CommodityService.selectCommodityById(id);
        boolean flag = (commodity!= null);
        return new R(flag,commodity,flag ? "查询成功" : "查询失败");
    }



    @ResponseBody
    @GetMapping("/selectALLCommodity")
    @ApiOperation(value = "商品查询接口", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public String selectALLCommodity() {
        ArrayList<Commodity> commodityList = CommodityService.selectALLCommodity();

        return JSON.toJSONString(commodityList);
    }



        @GetMapping("/updateCommodityById")
        @ResponseBody
        @ApiOperation(value = "商品修改接口", notes = "商品修改接口的说明")
        @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R updateCommodityById(Commodity commodity) {
        int count = CommodityService.updateCommodityById(commodity);
        boolean flag = (count > 0);
        return new R(flag,flag?"修改成功" : "修改失败");
    }

}


