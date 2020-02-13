package com.tensquare.qa.eurekaClient.Impl;

import com.tensquare.qa.eurekaClient.BaseClient;
import entity.Result;
import entity.StatusCode;

/**
 * 实现调用 tensquare-base 模块在 Eureka 服务注册中心发布的服务
 * Created by 叔公 on 2019-04-19.
 */
public class BaseClientImpl implements BaseClient {

    /**
     * 此方法是测试在 tensquare-base 模块没有开启服务时，熔断器会自动调用该方法，
     * 而不是报异常，这就是熔断器的强大之处
     *
     * @param labelId
     * @return
     */
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ACCESSERROR, "熔断器触发了");
    }
}
