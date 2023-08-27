package com.xpu.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:
 *
 * @author whd
 * @version 1.0.0
 * @date 2023/08/27 14:05:57
 */
@FeignClient(name = "order-manage-service")
@RequestMapping("/order")
public interface OrderFeignService {
    //不加@RequestParam 会变成post请求
    @ResponseBody
    @GetMapping("/selectUserAllOrderInfoByUserId")
    String selectUserAllOrderInfoByUserId(@RequestParam("uid") Integer uid);
}
