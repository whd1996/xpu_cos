package com.xpu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.Orderform;
import com.xpu.dao.OrderformDao;
import com.xpu.service.OrderformService;

@Service
public class OrderformServiceImpl extends ServiceImpl<OrderformDao, Orderform> implements OrderformService {
    @Resource
    OrderformDao orderformDao;

    @Override
    public int addOrder(Orderform order) {
        return orderformDao.insert(order);
    }


}

