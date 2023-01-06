package com.xpu.sevice.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.CommodityMapper;
import com.xpu.entity.Commodity;
import com.xpu.sevice.CommodityService;
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService{

}
