package com.xpu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "invoice")
@Data
@NoArgsConstructor
@TableName(value = "invoice")
public class Invoice implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "user_ID")
    @ApiModelProperty(value = "")
    private Integer userId;

    @TableField(value = "commodity_ID")
    @ApiModelProperty(value = "")
    private Integer commodityId;

    @TableField(value = "invoice_Date")
    @ApiModelProperty(value = "")
    private Date invoiceDate;

    @TableField(value = "orderForm_ID")
    @ApiModelProperty(value = "")
    private Integer orderformId;

    @TableField(value = "invoice_Drawer")
    @ApiModelProperty(value = "")
    private String invoiceDrawer;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_ID";

    public static final String COL_COMMODITY_ID = "commodity_ID";

    public static final String COL_INVOICE_DATE = "invoice_Date";

    public static final String COL_ORDERFORM_ID = "orderForm_ID";

    public static final String COL_INVOICE_DRAWER = "invoice_Drawer";
}