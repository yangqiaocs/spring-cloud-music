package com.ysj;

import com.ysj.danmu.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ysj.mapper")
public class DanMuApplication {
    public static void main(String[] args) {
        SpringApplication.run(DanMuApplication.class,args);
        NettyServer nettyServer = new NettyServer(6010);
        try {
            nettyServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
