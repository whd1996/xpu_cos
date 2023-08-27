package com.xpu.entity;

import lombok.Data;

/**
 * description: 封装登录时的请求参数
 *
 * @author whd
 * @version 1.0.0
 * @date 2023/08/27 12:17:42
 */
@Data
public class LoginUser {
    private int flag;
    private User user;
    @Data
    public static class User {
        private String username;
        private String password;
    }
}
