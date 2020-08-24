package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Student;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        User userDB = userDao.login(user);
        if(userDB!=null){
            return userDB;
        }
        throw new RuntimeException("登陆失败----");
    }

    @Override
    public List<Student> aaa() {
        return userDao.aaa();
    }
}
