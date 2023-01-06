package com.xpu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName(value = "orderform")
@ApiModel(value="订单表单对象",description="订单表单对象")
public class Orderform implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    // 使用ApiModelProperty来标注字段属性。
    @ApiModelProperty(value = "主键id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "用户id",required = true,example = "1001")
    @TableField(value = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "商品id",required = true,example = "100001")
    @TableField(value = "commodity_ID")
    private Integer commodityId;
    @ApiModelProperty(value = "购买数量",required = true,example = "20")
    @TableField(value = "commodity_Amount")
    private Integer commodityAmount;
    @ApiModelProperty(value = "消费金额",required = true,example = "99.9")
    @TableField(value = "orderForm_Price")
    private Double orderformPrice;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_COMMODITY_ID = "commodity_ID";

    public static final String COL_COMMODITY_AMOUNT = "commodity_Amount";

    public static final String COL_ORDERFORM_PRICE = "orderForm_Price";
}