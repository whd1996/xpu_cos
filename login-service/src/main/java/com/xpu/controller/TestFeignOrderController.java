package com.xpu.controller;

import com.alibaba.fastjson2.JSON;
import com.xpu.feignservice.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author whd
 * @version 1.0.0
 * @date 2023/08/27 14:19:27
 */
@RestController
@Slf4j
public class TestFeignOrderController {

    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping("selectUserAllOrderInfoByUserId/{uid}")
    public Object test(@PathVariable Integer uid) {
        String str = orderFeignService.selectUserAllOrderInfoByUserId(uid);
        log.info("str=>{}",str);
        return JSON.parse(str);
    }

}
