package com.xpu.service;

import com.xpu.entity.Purchaseorder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

public interface PurchaseorderService extends IService<Purchaseorder>{


    int addPurchaseorder(Purchaseorder purchaseorder);

    Purchaseorder selectPurchaseorderById(Integer id);

    int updatePurchaseorderById(Purchaseorder purchaseorder);


    int deletePurchaseorderById(Integer id);


    ArrayList<Purchaseorder> selectAllPurchaseorder();
}
