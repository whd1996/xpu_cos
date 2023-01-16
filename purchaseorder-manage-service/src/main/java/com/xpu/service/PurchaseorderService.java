package com.xpu.service;

import com.xpu.entity.Purchaseorder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public interface PurchaseorderService extends IService<Purchaseorder>{


    static ArrayList<Purchaseorder> selectALLPurchaseorder() {
        return null;
    }

    int addPurchaseorder(Purchaseorder purchaseorder);

    Purchaseorder selectPurchaseorderById(Integer id);

    int updatePurchaseorderById(Purchaseorder purchaseorder);


    int deletePurchaseorderById(Integer id);


    ArrayList<Purchaseorder> selectAllPurchaseorder();

    HashMap<String, Object> selectPurchaseorderInfoById(Integer pid);

    ArrayList<HashMap<String, Object>> selectAllPurchaseorderInfo();
}
