package com.xpu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.entity.Orderform;
import com.xpu.entity.R;
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
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Api(tags = "订单管理")
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderformService orderformService;

  /*  @ResponseBody
    @GetMapping("/selectOrderById")
    @ApiOperation(value = "根据id查询订单", notes = "根据id查询订单")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectOrderById(Integer id) {
        Orderform orderform = orderformService.selectOrderById(id);
        boolean flag = (orderform != null);
        return new R(flag,orderform,flag ? "查询成功" : "查询失败");
    }*/
    @ResponseBody
    @GetMapping("/selectOrderInfoById")
    @ApiOperation(value = "根据id查询订单详情", notes = "根据id查询订单详情")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectOrderInfoById(Integer oid) {
        HashMap<String,Object>  orderMap= orderformService.selectOrderInfoById(oid);
        boolean flag = (orderMap!=null);
        return new R(flag,orderMap,flag ? "查询成功" : "查询失败");
    }
    @ResponseBody
    @GetMapping("/selectAllOrder")
    @ApiOperation(value = "全部订单详情查询接口", notes = "所有订单详情查询接口")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectAllOrder() {
        ArrayList<HashMap<String,Object>> orderList = orderformService.selectAllOrder();
        boolean flag = orderList.isEmpty();
        return new R(true, orderList, flag ? "无内容" : "查询成功");
    }
/*    @ResponseBody
    @GetMapping("/selectUserAllOrderByUserId")
    @ApiOperation(value = "用户个人全部订单简单查询接口", notes = "用户个人所有订单查询接口,传入参数用户id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectUserAllOrderByUserId(Integer uid) {
        ArrayList<Orderform> orderList = orderformService.selectUserAllOrderByUserId(uid);
        boolean flag = orderList.isEmpty();
        return new R(true, orderList, flag ? "无内容" : "查询成功");
    }*/
    @ResponseBody
    @GetMapping("/selectUserAllOrderInfoByUserId")
    @ApiOperation(value = "用户个人全部订单详情查询接口", notes = "用户个人所有订单信息详情查询接口,传入参数用户id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectUserAllOrderInfoByUserId(Integer uid) {
        ArrayList<HashMap<String,Object>> orderList= orderformService.selectUserAllOrderInfoByUserId(uid);
        boolean flag = orderList.isEmpty();
        return new R(true, orderList, flag ? "无内容" : "查询成功");
    }

    /**
     * 分页查询所有订单信息
     * @return
     */
    @ResponseBody
    @GetMapping("/selectAllOrderUsePage")
    @ApiOperation(value = "分页查询全部订单", notes = "分页查询所有订单")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R selectAllOrderUsePage(Integer currentPage, Integer pageSize) {
        Page<Orderform> orderUsePage= orderformService.selectAllOrderUsePage(currentPage, pageSize);
        boolean flag = orderUsePage.getSize()>0;
        //如果参数页数大于最大页，则显示最后一页内容
        if (currentPage > orderUsePage.getPages()) {
            orderUsePage = orderformService.selectAllOrderUsePage((int) orderUsePage.getPages(), pageSize);
        }
        return new R(true, orderUsePage, flag ? "查询成功":"无内容");
    }

    /*
    @ResponseBody
    @PostMapping("/addOrder")
    @ApiOperation(value = "订单新增接口", notes = "订单新增接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R addOrder(@RequestBody Orderform orderform) {
        int count = orderformService.addOrder(orderform);
        boolean flag = count > 0;
        return new R(flag, flag ? "插入成功" : "插入失败");
    }
*/
/*  @ResponseBody
    @PostMapping("/updateOrderById")
    @ApiOperation(value = "订单修改接口", notes = "订单修改接口的说明:\n" +
            "只能修改订单中的商品购买数量")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R updateOrderById(@RequestBody Orderform orderform) {
        //查询原订单
        Orderform oldOrder = orderformService.selectOrderById(orderform.getId());
        if(oldOrder==null)
            return new R(false, "该编号订单不存在");
        int count = orderformService.updateOrderById(orderform);
        boolean flag = (count > 0);
        return new R(flag, flag ? "修改成功" : "修改失败");
    }*/
 /* @ResponseBody
    @GetMapping("/deleteOrderById")
    @ApiOperation(value = "订单删除接口", notes = "订单删除接口的说明")
    @ApiResponses({
            @ApiResponse(code = 200, message = "调用成功"),
            @ApiResponse(code = 401, message = "无权限")
    }
    )
    public R deleteOrderById(Integer id) {
        int count = orderformService.deleteOrderById(id);
        boolean flag = (count > 0);
        return new R(flag,flag?"删除成功" : "删除失败");
    }
*/

}
