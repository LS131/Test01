package com.baizhi.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class RequireJwt {
    public static void main(String[] args) {
       //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("k$er&%$")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTcyOTY2MjQsInVzZXJpZCI6MjEsInVzZXJuYW1lIjoi5bCP5piOIn0.b-ZCMNe6NAFZ5cEIRCa8xuawmDQi3hIkP73-9GLnrsQ");
        verify.getClaims().get("userid").asInt();
        System.out.println(verify.getClaim("userid").asInt());//需进行对应的转型

        System.out.println(verify.getClaim("username").asString());


    }
}
