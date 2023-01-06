package com.xpu.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.CommodityDao;
import com.xpu.entity.Commodity;
import com.xpu.service.CommodityService;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, Commodity> implements CommodityService {

}

