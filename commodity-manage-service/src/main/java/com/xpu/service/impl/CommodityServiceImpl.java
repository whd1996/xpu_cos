package com.xpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.CommodityMapper;
import com.xpu.entity.Commodity;
import com.xpu.service.CommodityService;
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

    @Override
    public ArrayList<Commodity> selectPurchaseCommodity() {
        QueryWrapper<Commodity> qw = new QueryWrapper<>();
        qw.le("commodity_repertory",10);
        return (ArrayList<Commodity>) commodityMapper.selectList(qw);
    }

    @Override
    public Page<Commodity> selectALLCommodityUsePage(Integer currentPage, Integer pageSize) {
        Page<Commodity> page = new Page<>(currentPage, pageSize);
        return commodityMapper.selectPage(page,null);
    }

    @Override
    public Commodity selectCommodityByName(String commodityName) {
        QueryWrapper<Commodity> qw = new QueryWrapper<>();
        qw.eq("commodity_name",commodityName);
        return commodityMapper.selectOne(qw);
    }


}
