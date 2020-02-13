package com.tensquare.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * 交友模块启动类
 * Created by 叔公 on 2019-04-14.
 */
@SpringBootApplication
@EnableEurekaClient //Eureka 客户端，将服务注册到 Eureka 服务注册中心
@EnableDiscoveryClient //发现服务
@EnableFeignClients //发现服务
public class FriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
