package com.xpu.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "跳转管理")
@Controller
public class IndexController {
    @ApiResponses({
            @ApiResponse(code = 200, message = "页面跳转成功"),
            @ApiResponse(code = 401, message = "无权限")
    })
    @ApiOperation(value = "跳转接口", notes = "页面跳转的说明")
    @GetMapping("/index")
    public String toIndex(){

        return "login";
    }
    @GetMapping("/toLogin")
    public String toLogin(){
            return "toLogin";
    }
}
