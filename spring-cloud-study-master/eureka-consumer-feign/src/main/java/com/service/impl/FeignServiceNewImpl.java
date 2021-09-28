package com.service.impl;

import com.service.FeignService;
import com.service.FeignServiceNew;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceNewImpl implements FallbackFactory<FeignServiceNew> {

    private Logger logger = LoggerFactory.getLogger(FeignServiceNewImpl.class);

    @Override
    public FeignServiceNew create(Throwable throwable) {
        logger.error("hystrix熔断机制触发!异常信息为: ", throwable);
        return new FeignServiceNew(){
            @Override
            public String sellProduct(String productName) {
                return "对不起,服务挂了哦!!";
            }
        };
    }
}
