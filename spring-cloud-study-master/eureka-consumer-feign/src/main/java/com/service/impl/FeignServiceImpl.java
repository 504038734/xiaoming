package com.service.impl;

import com.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

    @Override
    public String sellProduct(String productName) {
        return "对不起,服务挂了哦!!";
    }
}
