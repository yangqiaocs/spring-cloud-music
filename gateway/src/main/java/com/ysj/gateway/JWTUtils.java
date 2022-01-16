package com.ysj.gateway;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.UUID;

public class JWTUtils {


    @Autowired
    private RedisTemplate redisTemplate;

    private static long EXPERIES_TIME = 1000 * 60 * 60 * 24;
    private static long REFRESH_TIME = 1000 * 60 * 64 * 24;
    private static String signature  = "test-jwt";

    public static String createJWT(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("username","ysj")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+EXPERIES_TIME))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }

    public static boolean verify(String token){
        JwtParser jwtParser = Jwts.parser();
        return true;
//        try{
//            Jws<Claims> claimsJws =  jwtParser.setSigningKey(signature).parseClaimsJws(token);
//            System.out.println(claimsJws.getBody().get("username"));
//        }catch (Exception e){
//            return false;
//        }
//        return true;
    }

    public static void main(String[] args) {
        String token = JWTUtils.createJWT();
        JWTUtils.verify(token);
    }


}
