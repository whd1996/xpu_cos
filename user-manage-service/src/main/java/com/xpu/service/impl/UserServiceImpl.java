package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.UserDao;
import com.xpu.entity.User;
import com.xpu.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    UserDao userDao;
    @Override
    public int insertUser(User record) {
        return userDao.insert(record);
    }


    // 删除方法
    @Override
    public boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }
    /**
     * @Cacheable: 将该方法查询结果comment存放在SpringBoot默认缓存中
     * cacheNames: 起一个缓存的命名空间，对应缓存的唯一标识
     * value：缓存结果   key：默认只有一个参数的情况下，key值默认就是方法参数值; 如果没有参数或者多个参数的情况：会使用SimpleKeyGenerate来为生成key
     */
    @Cacheable(cacheNames = "user",unless ="#result==null")
    @Override
    public User selectUserById(Integer id) {
        User user = userDao.selectById(id);
        return user;
    }
}
