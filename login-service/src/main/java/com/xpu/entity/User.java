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
    @TableId(value = "user表主键id，业务无关", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_Name")
    @ApiModelProperty(value="用户名",example = "zhangsan")
    private String userName;

    @TableField(value = "user_Passward")
    @ApiModelProperty(value="用户密码",example = "1234")
    private String userPassward;

    private String nickname;


    private String userPhone;


    private String address;


    private Integer roleId;
    public static final String COL_ID = "id";

    public static final String COL_USER_NAME = "user_Name";

    public static final String COL_USER_PASSWARD = "user_Passward";

    public static final String COL_NICKNAME = "nickName";

    public static final String COL_USER_PHONE = "user_phone";

    public static final String COL_ADDRESS = "address";

    public static final String COL_ROLE_ID = "role_ID";
}