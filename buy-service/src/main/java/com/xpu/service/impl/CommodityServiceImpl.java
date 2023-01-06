package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.CommodityDao;
import com.xpu.entity.Commodity;
import com.xpu.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, Commodity> implements CommodityService {
    @Resource
    CommodityDao commodityDao;
    @Override
    public Commodity selectCommodityById(int id) {
        return commodityDao.selectById(id);
    }

    @Override
    public boolean updateCommodity(Commodity good) {
        return commodityDao.updateById(good)>0;
    }
}

