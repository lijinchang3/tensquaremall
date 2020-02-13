package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Created by 叔公 on 2019-03-31.
 */
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args){
        SpringApplication.run(SearchApplication.class,args);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
}
