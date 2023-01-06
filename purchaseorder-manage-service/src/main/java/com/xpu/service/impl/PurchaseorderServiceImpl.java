package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.PurchaseorderDao;
import com.xpu.entity.Purchaseorder;
import com.xpu.service.PurchaseorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class PurchaseorderServiceImpl extends ServiceImpl<PurchaseorderDao, Purchaseorder> implements PurchaseorderService{
    @Resource
    PurchaseorderDao purchaseorderDao;
    @Override
    public int addPurchaseorder(Purchaseorder purchaseorder) {
        return purchaseorderDao.insert(purchaseorder);
    }

    @Override
    public Purchaseorder selectPurchaseorderById(Integer id) {
        return purchaseorderDao.selectById(id);
    }

    @Override
    public int updatePurchaseorderById(Purchaseorder purchaseorder) {
        return purchaseorderDao.updateById(purchaseorder);
    }

    @Override
    public int deletePurchaseorderById(Integer id) {
        return purchaseorderDao.deleteById(id);
    }

    @Override
    public ArrayList<Purchaseorder> selectAllPurchaseorder() {
        return purchaseorderDao.selectAllPurchaseorder();
    }

}
