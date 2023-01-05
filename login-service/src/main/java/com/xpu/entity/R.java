package com.xpu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 发给前端的统一数据格式
 */
@Data
@NoArgsConstructor
@ApiModel(value="通用响应",description="通用响应对象")
public class R implements Serializable {
    @ApiModelProperty(value = "返回操作状态", example = "true")
    private Boolean flag;
    @ApiModelProperty(value = "返回对象", example = "Object")
    private Object data;
    @ApiModelProperty(value = "返回消息", example = "消息")
    private String msg;

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
    public R(Boolean flag, Object data,String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg) {
        this(false, msg);
    }
}
