package com.xpu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

public interface CommodityService extends IService<Commodity>{


    int addCommodity(Commodity commodityform);

    Commodity selectCommodityById(Integer id);

    int deleteCommodityById(Integer id);

    int updateCommodityById(Commodity commodity);

    ArrayList<Commodity> selectALLCommodity();

    ArrayList<Commodity> selectPurchaseCommodity();

    Page<Commodity> selectALLCommodityUsePage(Integer currentPage, Integer pageSize);

    Commodity selectCommodityByName(String commodityName);
}
