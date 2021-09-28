package com.service;

import com.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 调用
 *正常实现接口方式进行熔断
 */
@FeignClient(value = "eureka-provider",fallback = FeignServiceImpl.class)
public interface FeignService {

    @RequestMapping("/sellProduct")
    String sellProduct(@RequestParam(value = "productName") String productName);

}
