package com.xpu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.dao.OrderformDao;
import com.xpu.entity.Orderform;
import com.xpu.service.OrderformService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OrderformServiceImpl extends ServiceImpl<OrderformDao, Orderform> implements OrderformService{

    @Resource
    OrderformDao orderformDao;
    @CachePut(cacheNames = "orderInfo",key = "'orderInfo'+#p0.id",unless ="#result==0")
    @Override
    public int addOrder(Orderform orderform) {
        return orderformDao.insert(orderform);
    }

    @Cacheable(cacheNames = "order",key = "#p0",unless ="#result==null")
    @Override
    public Orderform selectOrderById(Integer id) {
        return orderformDao.selectById(id);
    }
    @Cacheable(cacheNames = "orderInfo",key = "'orderInfo'+#p0",unless ="#result==null")
    @Override
    public HashMap<String, Object> selectOrderInfoById(Integer oid) {
        return orderformDao.selectOrderInfoById(oid);
    }

    @CachePut(value = "order", key = "#p0.id",unless ="#result==0")
    @Override
    public int updateOrderById(Orderform orderform) {
        return orderformDao.updateById(orderform);
    }
    @CacheEvict(cacheNames = "order",key ="#p0")
    @Override
    public int deleteOrderById(Integer id) {

        return orderformDao.deleteById(id);
    }
    @Override
    @CachePut(cacheNames = "allOrderList",key ="'allOrderList'", unless ="#result.isEmpty()")
    public ArrayList<HashMap<String,Object>> selectAllOrder() {
        return  orderformDao.selectAllOrder();
    }

    @CachePut(cacheNames = "allOrderInfoList",key ="'allOrderInfoList'+#p0", unless ="#result.isEmpty()")
    @Override
    public ArrayList<HashMap<String, Object>> selectUserAllOrderInfoByUserId(Integer uid) {
        return orderformDao.selectUserAllOrderInfoByUserId(uid);
    }

    @Override
    @CachePut(cacheNames = "userOrderList", key = "'userOrderList'+#p0", unless = "#result.isEmpty()")
    public ArrayList<Orderform> selectUserAllOrderByUserId(Integer uid) {
        QueryWrapper<Orderform> qw = new QueryWrapper<>();
        qw.eq("user_id", uid);
        return (ArrayList<Orderform>) orderformDao.selectList(qw);
    }


    /**
     * 分页查询  需要配置PaginationInnerInterceptor分页查询插件
     *
     * @return
     */
    @CachePut(cacheNames = "OrderPage", key = "'OrderPage'+#result.pages+'_'+#p0+'_'+#p1", unless = "#result.getSize()==0")
    @Override
    public Page<Orderform> selectAllOrderUsePage(int currentPage,int pageSize) {
        Page<Orderform> page = new Page<>(currentPage, pageSize);
        return orderformDao.selectPage(page, null);
    }

}
