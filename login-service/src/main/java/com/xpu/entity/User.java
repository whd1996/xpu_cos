package com.xpu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value="用户登录表单对象",description="用户登录表单对象")
public class User {
    public static final String COL_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    @ApiModelProperty(value = "用户id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名",required = true,example = "张三")
    private String username;
    @ApiModelProperty(value = "用户密码",required = true,example = "123456")
    private String password;
}