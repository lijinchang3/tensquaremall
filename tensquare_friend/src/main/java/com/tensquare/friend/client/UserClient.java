package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用 tensquare-user 模块注册到 Eureka 服务注册中心的服务
 */
@Component
@FeignClient("tensquare-user") //指定服务名
public interface UserClient {
    /**
     * 调用的方法
     *
     * @param userid
     * @param friendid
     * @param x
     */
    @RequestMapping(value = "/user/{userid}/{friendid}/{x}", method = RequestMethod.PUT)
    void updatefanscountandfollowcount(@PathVariable("userid") String userid, @PathVariable("friendid") String friendid, @PathVariable("x") int x);
}
