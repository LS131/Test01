package com.baizhi.dao;

import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //@Mapper这样写就省去了@MapperScan()
public interface UserDao {

    User login(User user);//登陆接口

    List<Teacher> select();

    List<Student> aaa();
}
