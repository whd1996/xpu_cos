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

@ApiModel(value="`admin`")
@Data
@NoArgsConstructor
@TableName(value = "`admin`")
public class Admin implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键id")
    private Integer id;

    @TableField(value = "admin_Name")
    @ApiModelProperty(value="")
    private String adminName;

    @TableField(value = "admin_Password")
    @ApiModelProperty(value="")
    private String adminPassword;

    @TableField(value = "`name`")
    @ApiModelProperty(value="")
    private String name;

    public static final String COL_ID = "id";

    public static final String COL_ADMIN_NAME = "admin_Name";

    public static final String COL_ADMIN_PASSWORD = "admin_Password";

    public static final String COL_NAME = "name";
}