package com.xpu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.entity.Commodity;
import com.xpu.entity.R;
import com.xpu.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@Api(tags = "商品管理")
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    CommodityService CommodityService;

    @ResponseBody
    @PostMapping("/addCommodity")
    @ApiOperation(value = "商品新增接口", notes = "商品新增接口的说明")
    @ApiResponses({@ApiResponse(code = 200, message = "调用成功"), @ApiResponse(code = 401, message = "无权限")})
    public R addCommodity(@RequestBody Commodity commodity) {
        Commodity webCommodity=CommodityService.selectCommodityByName(commodity.getCommodityName());
        if(webCommodity!=null)
            return new R(false, "该商品已存在");
        int count = CommodityService.addCommodity(commodity);
        boolean flag = count > 0;
        return new R(flag, flag ? "插入成功" : "插入失败");
    }


    @ResponseBody
    @GetMapping("/selectALLCommodity")
    public R selectALLCommodity() {
        ArrayList<Commodity> commodityList = CommodityService.selectALLCommodity();
        boolean flag = (!commodityList.isEmpty());
        return new R(true, commodityList, flag ? "查询成功" : "无商品信息");

    }

    @PostMapping("/updateCommodityById")
    @ResponseBody
    @ApiOperation(value = "商品修改接口", notes = "商品修改接口的说明\nid不传参")
    @ApiResponses({@ApiResponse(code = 200, message = "调用成功"), @ApiResponse(code = 401, message = "无权限")})
    public R updateCommodityById(@RequestBody Commodity commodity) {
        int count = CommodityService.updateCommodityById(commodity);
        boolean flag = (count > 0);
        return new R(flag, flag ? "修改成功" : "修改失败");
    }

    @ResponseBody
    @GetMapping("/selectALLCommodityUsePage")
    public R selectALLCommodityUsePage(Integer currentPage, Integer pageSize,HttpServletRequest req) {
        Page<Commodity> commodityPage = CommodityService.selectALLCommodityUsePage(currentPage,pageSize);
        boolean flag =commodityPage.getSize()>0;
        req.getSession().setAttribute("commodityPage",commodityPage);
        return new R(true, commodityPage, flag ? "查询成功" : "无商品信息");
    }
    @ResponseBody
    @GetMapping("/selectCommodityById")
    @ApiOperation(value = "根据id商品查询接口", notes = "根据id商品查询接口的说明")
    @ApiResponses({@ApiResponse(code = 200, message = "调用成功"), @ApiResponse(code = 401, message = "无权限")})
    public R selectCommodityById(Integer id) {
        Commodity commodity = CommodityService.selectCommodityById(id);
        boolean flag = (commodity != null);
        return new R(flag, commodity, flag ? "查询成功" : "查询失败");
    }
 /*   @ResponseBody
    @GetMapping("/deleteCommodityById")
    @ApiOperation(value = "商品删除接口", notes = "商品删除接口的说明")
    @ApiResponses({@ApiResponse(code = 200, message = "调用成功"), @ApiResponse(code = 401, message = "无权限")})
    public R deleteCommodityById(Integer id) {
        int count = CommodityService.deleteCommodityById(id);
        boolean flag = (count > 0);
        return new R(flag, flag ? "删除成功" : "删除失败");
    }*/
}


