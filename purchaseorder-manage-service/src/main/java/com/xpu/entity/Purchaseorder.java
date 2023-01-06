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

@ApiModel(value="purchaseorder")
@Data
@NoArgsConstructor
@TableName(value = "purchaseorder")
public class Purchaseorder implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "commodity_ID")
    @ApiModelProperty(value="")
    private Integer commodityId;

    @TableField(value = "add_Amount")
    @ApiModelProperty(value="")
    private Integer addAmount;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_COMMODITY_ID = "commodity_ID";

    public static final String COL_ADD_AMOUNT = "add_Amount";
}