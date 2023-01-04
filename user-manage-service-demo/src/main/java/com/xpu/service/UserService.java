package com.xpu.service;

import com.xpu.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int insertUser(User record);
    boolean delete(Integer id);
    User selectUserById(Integer id);
    int updateUser(User user);
}


