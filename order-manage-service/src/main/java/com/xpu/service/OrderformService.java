package com.xpu.service;

import com.xpu.entity.Orderform;
import com.baomidou.mybatisplus.extension.service.IService;
public interface OrderformService extends IService<Orderform>{


    int addOrder(Orderform orderform);

    Orderform selectOrderById(Integer id);
}
