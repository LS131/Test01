package com.baizhi.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
@ToString
@Data
@Accessors(chain = true)
public class Teacher {
    private Integer tid;
    private String tname;
    private Student student;
    private List<Student> students;
    public Teacher(){
        System.out.println("Teacher对象创建一次");
    }
}
