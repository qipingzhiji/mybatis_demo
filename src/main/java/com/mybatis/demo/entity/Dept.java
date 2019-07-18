package com.mybatis.demo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("dept")
@Data
public class Dept {
    private Integer id;
    private String deptName;
    List<Teacher> teachers;
}
