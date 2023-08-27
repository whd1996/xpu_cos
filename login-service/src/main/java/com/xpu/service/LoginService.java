package com.xpu.service;

import com.xpu.entity.LoginUser;
import com.xpu.entity.R;
import com.xpu.entity.User;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author whd
 * @version 1.0.0
 * @date 2023/08/27 11:37:44
 */
@Service
public interface LoginService {
    R login(LoginUser loginUser);


    R userRegister(User user);
}
