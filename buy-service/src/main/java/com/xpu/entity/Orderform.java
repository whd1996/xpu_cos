package com.xpu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "orderform")
@Data
@NoArgsConstructor
@TableName(value = "orderform")
public class Orderform implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "")
    private Integer userId;

    @TableField(value = "commodity_ID")
    @ApiModelProperty(value = "")
    private Integer commodityId;

    @TableField(value = "commodity_Amount")
    @ApiModelProperty(value = "")
    private Integer commodityAmount;

    @TableField(value = "orderForm_Price")
    @ApiModelProperty(value = "")
    private Double orderformPrice;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_COMMODITY_ID = "commodity_ID";

    public static final String COL_COMMODITY_AMOUNT = "commodity_Amount";

    public static final String COL_ORDERFORM_PRICE = "orderForm_Price";
}