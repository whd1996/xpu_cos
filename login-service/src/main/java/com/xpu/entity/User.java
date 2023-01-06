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

@ApiModel(value="`user`")
@Data
@NoArgsConstructor
@TableName(value = "`user`")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "user_Name")
    @ApiModelProperty(value="用户")
    private String userName;

    @TableField(value = "user_Passward")
    @ApiModelProperty(value="用户密码",example = "1234")
    private String userPassward;

    @TableField(value = "nickName")
    @ApiModelProperty(value="昵称",example = "张三")
    private String nickname;

    @TableField(value = "user_phone")
    @ApiModelProperty(value="用户电话",example = "12345678910")
    private String userPhone;

    @TableField(value = "address")
    @ApiModelProperty(value="地址",example = "陕西")
    private String address;

    @TableField(value = "role_ID")
    @ApiModelProperty(value="角色标志",example = "001")
    private Integer roleId;

    public static final String COL_ID = "id";

    public static final String COL_USER_NAME = "user_Name";

    public static final String COL_USER_PASSWARD = "user_Passward";

    public static final String COL_NICKNAME = "nickName";

    public static final String COL_USER_PHONE = "user_phone";

    public static final String COL_ADDRESS = "address";

    public static final String COL_ROLE_ID = "role_ID";
}