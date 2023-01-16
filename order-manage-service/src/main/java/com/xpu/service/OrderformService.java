package com.xpu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.entity.Orderform;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderformService extends IService<Orderform>{


    int addOrder(Orderform orderform);

    Orderform selectOrderById(Integer id);

    HashMap<String, Object> selectOrderInfoById(Integer oid);

    int updateOrderById(Orderform orderform);

    int deleteOrderById(Integer id);
    ArrayList<HashMap<String,Object>>selectAllOrder();

    ArrayList<Orderform> selectUserAllOrderByUserId(Integer id);

    ArrayList<HashMap<String, Object>> selectUserAllOrderInfoByUserId(Integer uid);

    Page<Orderform> selectAllOrderUsePage(int currentPage,int pageSize);
}
