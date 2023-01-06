package com.xpu.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.CommodityMapper;
import com.xpu.entity.Commodity;
import com.xpu.sevice.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService{
    @Resource
    CommodityMapper commodityMapper;

    @Override
    public int addCommodity(Commodity commodityform) {
        return commodityMapper.insert(commodityform);
    }

    @Override
    public Commodity selectCommodityById(Integer id) {

        return commodityMapper.selectById(id);
    }


    @Override
    public int deleteCommodityById(Integer id) {
        return commodityMapper.deleteById(id);
    }

    @Override
    public int updateCommodityById(Commodity commodity) {
        return commodityMapper.updateById(commodity);
    }

    @Override
    public ArrayList<Commodity> selectALLCommodity() {
        return commodityMapper.selectALLCommodity();
    }


}
