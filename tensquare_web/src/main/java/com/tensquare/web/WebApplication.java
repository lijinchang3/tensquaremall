package com.tensquare.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by 叔公 on 2019-04-20.
 */
@SpringBootApplication
@EnableEurekaClient // Eureka 客户端，将服务注册到 Eureka 服务注册中心
@EnableZuulProxy // 网关
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
