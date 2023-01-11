package com.xpu.service;

import com.xpu.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CommodityService extends IService<Commodity> {


    Commodity selectCommodityById(int id);

    boolean updateCommodity(Commodity good);
}

