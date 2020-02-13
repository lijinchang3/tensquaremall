package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * Created by 叔公 on 2019-04-20.
 */
@SpringBootApplication
@EnableEurekaClient // Eureka 客户端，将服务注册到 Eureka 服务注册中心
@EnableZuulProxy // 网关
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
