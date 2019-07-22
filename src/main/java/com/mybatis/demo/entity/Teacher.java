package com.mybatis.demo.entity;

import lombok.Data;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias(value = "teacher")
public class Teacher implements Serializable{


    private Integer id;
    private String name;
    private String subject;
    private Integer deptNum;
    private int sex;
    private String comment;
    private Dept dept;
}
