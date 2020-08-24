package com.baizhi.controller;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Teacher;
import com.mysql.cj.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private UserDao userDao;
    @GetMapping("/test/test")
    public String test(String username, HttpServletRequest request){
        //认证成功之后放入session
        request.getSession().setAttribute("username",username);
        return "login ok--";
    }

    @GetMapping("select")
    public List<Teacher> select(){
        List<Teacher> teachers = userDao.select();
        return teachers;
    }


}
