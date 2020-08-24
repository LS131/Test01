package com.baizhi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SING = "k$er&%$";
    /**
     * 生成token header payload sing
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);//默认七天过期

        JWTCreator.Builder builder = JWT.create();
        //创建JWT Builder     payload
        map.forEach((v,k)->{
            builder.withClaim(k,v);
        });

        String token = builder.withExpiresAt(instance.getTime())//指定令牌的过期时间
                .sign(Algorithm.HMAC256(SING));//sign

       return token;
    }
    /**
     * 验证Token合法性
     */
    public static void verify(String token){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SING)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
    }

    /**
     * 获取token信息
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);;
        return verify;
    }
}
