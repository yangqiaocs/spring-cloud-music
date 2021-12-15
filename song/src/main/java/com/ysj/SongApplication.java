package com.ysj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ysj.mapper")
public class SongApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class,args);
    }
}
