package com.tensquare.qa.eurekaClient;

import com.tensquare.qa.eurekaClient.Impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用 base 模块在 Eureka 服务注册中心发布的服务
 */
//@FeignClient(value = "tensquare-base")//发现的服务名
@FeignClient(value = "tensquare-base", fallback = BaseClientImpl.class)//value：指定发现的服务名，fallback:熔断器调用的实现类
public interface BaseClient {

    /**
     * 调用的方法
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    Result findById(@PathVariable("labelId") String labelId);
}
