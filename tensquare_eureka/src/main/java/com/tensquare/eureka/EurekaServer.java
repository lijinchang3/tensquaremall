package com.tensquare.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务启动类
 * 启动后可以直接访问路径 : http://127.0.0.1:6868
 * Created by 叔公 on 2019-04-14.
 */
@SpringBootApplication
@EnableEurekaServer // Eureka 服务
public class EurekaServer {

    public static void main(String[] args){
        SpringApplication.run(EurekaServer.class);
    }
}
