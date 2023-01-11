package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.Purchaseorder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PurchaseorderService extends IService<Purchaseorder>{


    int addPurchaseorder(Purchaseorder purchaseorder);

    Purchaseorder selectPurchaseorderById(Integer id);

    int updatePurchaseorderById(Purchaseorder purchaseorder);


    int deletePurchaseorderById(Integer id);


    ArrayList<Purchaseorder> selectAllPurchaseorder();
}
