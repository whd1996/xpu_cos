package com.xpu.utils;

import org.springframework.util.DigestUtils;

/**
 * MD5加密 用户密码
 *
 * @author whd
 */
public class MD5Utils {

    //盐
    private static final String salt = "这个串是XPU-COS系统Md5加密所用盐值-万鸿达、" +
            "陈永涛、寇喆、李鹏飞、张嘉奇、史绪豪、凌寒、李欣宇";

    public static String getMD5(String string) {
        String val = string + salt;
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123"));
    }

}
