package com.baizhi.controller;


import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login") //Map<String,Object>
    public void login(@RequestBody User user, HttpServletResponse response) throws IOException {
        log.info("用户名:"+user.getName());
        log.info("密码:"+user.getPassword());
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            User userDB = userService.login(user);
            Map<String,String> payload = new HashMap<String,String>();
            payload.put("id",userDB.getId());
            payload.put("name",userDB.getName());
            //生成JWT令牌
            String token = JWTUtils.getToken(payload);
            map.put("token",token);
            map.put("state",true);
            map.put("msg","认证成功");
            //响应token
            map.put("token",token);
        }catch (RuntimeException e){
            map.put("state",false);
            map.put("msg","认证失败");
        }
        //return map;
        PrintWriter writer = response.getWriter();
        writer.print(new ObjectMapper().writeValueAsString(map));
        writer.flush();
    }

    @PostMapping("/user/test")//405请求方式不对
    public Map<String,Object> test(String token){
        Map<String,Object> map = new HashMap<String,Object>();
        log.info("当前token为:"+token);
        map.put("state",true);
        map.put("msg","请求成功");
        return map;
    }

    @GetMapping("/AAAtest")
    public List<Student> aaa()
    {
        return userService.aaa();
    }
}
