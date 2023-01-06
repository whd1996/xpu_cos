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
@TableName(value = "purchaseorder")
@ApiModel(value="采购订单表单对象",description="采购订单对象")
public class Purchaseorder implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="采购订单主键id",example = "1")
    private Integer id;

    @TableField(value = "commodity_ID")
    @ApiModelProperty(value="商品id" ,example = "1001")
    private Integer commodityId;

    @TableField(value = "add_Amount")
    @ApiModelProperty(value="采购该商品的数量",example = "20")
    private Integer addAmount;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_COMMODITY_ID = "commodity_ID";

    public static final String COL_ADD_AMOUNT = "add_Amount";
}