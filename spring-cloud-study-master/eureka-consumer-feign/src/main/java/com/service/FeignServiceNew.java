package com.service;

import com.service.impl.FeignServiceNewImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 调用
 *fallbackFactory方式实现接口进行熔断,可打印异常
 */
@FeignClient(value = "eureka-provider",fallbackFactory = FeignServiceNewImpl.class)
public interface FeignServiceNew {

    @RequestMapping("/sellProduct")
    String sellProduct(@RequestParam(value = "productName") String productName);

}
