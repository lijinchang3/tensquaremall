package com.tensquare.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 该模块是将可以在gitee上读取其他模块的application.yml文件的
 * 例如访问: http:127.0.0.1:12000/base-dev.yml 就可以访问到base模块的配置文件
 * Created by 叔公 on 2019-04-20.
 */
@EnableConfigServer //开启配置服务
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
