package com.xpu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xpu.entity.Commodity;

public interface CommodityService extends IService<Commodity> {


    Commodity selectCommodityById(int id);

    boolean updateCommodity(Commodity good);


}

