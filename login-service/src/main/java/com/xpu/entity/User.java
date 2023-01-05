package com.xpu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="`user`")
@Data
@NoArgsConstructor
@TableName(value = "`user`")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "user_Name")
    @ApiModelProperty(value="")
    private String userName;

    @TableField(value = "user_Passward")
    @ApiModelProperty(value="")
    private String userPassward;

    @TableField(value = "nickName")
    @ApiModelProperty(value="")
    private String nickname;

    @TableField(value = "user_phone")
    @ApiModelProperty(value="")
    private String userPhone;

    @TableField(value = "address")
    @ApiModelProperty(value="")
    private String address;

    @TableField(value = "role_ID")
    @ApiModelProperty(value="")
    private Integer roleId;

    public static final String COL_ID = "id";

    public static final String COL_USER_NAME = "user_Name";

    public static final String COL_USER_PASSWARD = "user_Passward";

    public static final String COL_NICKNAME = "nickName";

    public static final String COL_USER_PHONE = "user_phone";

    public static final String COL_ADDRESS = "address";

    public static final String COL_ROLE_ID = "role_ID";
}