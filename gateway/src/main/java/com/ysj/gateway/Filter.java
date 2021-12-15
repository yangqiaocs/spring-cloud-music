package com.ysj.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class Filter implements GlobalFilter, Ordered {

    private String[] skipAuthUrls = {"/user/login"};


    @Autowired
    private RedisTemplate redisTemplate;

    public boolean isSkipUrl(String url) {
        for (String skipAuthUrl : skipAuthUrls) {
            if (url.startsWith(skipAuthUrl)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url =  exchange.getRequest().getURI().getPath();
        System.out.println(url);
        if(null != skipAuthUrls && isSkipUrl(url)){
            System.out.println(url+ "跳过验证");
            return chain.filter(exchange);
        }


        String token = exchange.getRequest().getHeaders().getFirst("token");
        System.out.println(token);
        if (!JWTUtils.verify(token)){
            System.out.println(("token验证失败"));
            // 设置状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }
        // 返回
        System.out.println(("验证通过"));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
