package com.ysj.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class JWTUtils {



    private static long EXPERIES_TIME = 1000 * 60 * 24 * 60;
    private static long REFRESH_TIME = 1000 * 60 * 24 * 60;
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

        try{
            Jws<Claims> claimsJws =  jwtParser.setSigningKey(signature).parseClaimsJws(token);

        }catch (Exception e){
            return false;
        }
        return true;


    }


}
