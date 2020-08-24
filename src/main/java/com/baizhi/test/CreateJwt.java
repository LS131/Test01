package com.baizhi.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.HashMap;

public class CreateJwt {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<String,Object>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,60);//20秒后过期

        String token = JWT.create().withHeader(map)//header
                .withClaim("userid",21)//payload
                .withClaim("username","小明")
                .withExpiresAt(instance.getTime())//指定令牌的过期时间  getTime()得到的是时间
                .sign(Algorithm.HMAC256("k$er&%$"));//签名 密钥随便写
        System.out.println("GetTime:"+instance.getTime());
        System.out.println(token);
    }
}
