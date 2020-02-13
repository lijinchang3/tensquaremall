package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Created by 叔公 on 2019-02-24.
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // Eureka 客户端，将服务注册到 Eureka 服务注册中心
public class BaseApplication {
    /**
     * base模块的程序入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    /**
     * 将 util.IdWorker 注入到 spring 容器中
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }


}
