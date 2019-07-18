package com.mybatis.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private int id;
    private String name;
    private int age;
    private Date birth;
}
