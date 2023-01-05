package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.OrderformDao;
import com.xpu.entity.Orderform;
import com.xpu.service.OrderformService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class OrderformServiceImpl extends ServiceImpl<OrderformDao, Orderform> implements OrderformService{
    @Resource
    OrderformDao orderformDao;
    @Override
    public int addOrder(Orderform orderform) {
        return orderformDao.insert(orderform);
    }

    @Cacheable(cacheNames = "order",unless ="#result==null")
    @Override
    public Orderform selectOrderById(Integer id) {
        return orderformDao.selectById(id);
    }
}
