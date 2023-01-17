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

@ApiModel(value="commodity")
@Data
@NoArgsConstructor
@TableName(value = "commodity")
public class Commodity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="商品主键id",example = "1")
    private Integer id;

    @TableField(value = "commodity_Name")
    @ApiModelProperty(value="商品名称",example = "苹果")
    private String commodityName;

    @TableField(value = "commodity_repertory")
    @ApiModelProperty(value="库存",example = "100")
    private Integer commodityRepertory;

    @TableField(value = "upOrDown")
    @ApiModelProperty(value="上架/下架",example = "1")
    private Integer upordown;

    @TableField(value = "commodity_price")
    @ApiModelProperty(value="商品价格",example = "15.5")
    private Double commodityPrice;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_COMMODITY_NAME = "commodity_Name";

    public static final String COL_COMMODITY_REPERTORY = "commodity_repertory";

    public static final String COL_UPORDOWN = "upOrDown";

    public static final String COL_COMMODITY_PRICE = "commodity_price";
}