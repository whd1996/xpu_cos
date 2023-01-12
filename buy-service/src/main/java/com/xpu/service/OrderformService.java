package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.Orderform;

public interface OrderformService extends IService<Orderform> {


    int addOrder(Orderform order);

}

