package com.xpu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.entity.Orderform;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

public interface OrderformService extends IService<Orderform>{


    int addOrder(Orderform orderform);

    Orderform selectOrderById(Integer id);

    int updateOrderById(Orderform orderform);

    int deleteOrderById(Integer id);

    ArrayList<Orderform> selectAllOrder();
    ArrayList<Orderform> selectUserAllOrderByUserId(Integer id);

    Page<Orderform> selectAllOrderUsePage(int currentPage,int pageSize);
}
