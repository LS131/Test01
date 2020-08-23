package com.baizhi.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student {
    private Integer sid;
    private String sname;
    private Teacher teacher;
    public Student(){
        System.out.println("Student对象创建一次");
    }
}
