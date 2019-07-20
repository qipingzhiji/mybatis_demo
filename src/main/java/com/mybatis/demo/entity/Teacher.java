package com.mybatis.demo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias(value = "teacher")
public class Teacher {
    private Integer id;
    private String name;
    private String subject;
    private Integer deptNum;
    private int sex;
    private String comment;
    private Dept dept;
}
