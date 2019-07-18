package com.mybatis.demo.controller;

import com.mybatis.demo.entity.Dept;
import com.mybatis.demo.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptMapper dao;

    @RequestMapping("/dept")
    public Object selectDept(){
        return dao.selectDeptById(2);
    }

    @RequestMapping("/deptAndTeachers")
    public Object selectDeptandTeachers(){
        return dao.selectDeptAndTeachers(2);
    }

    @RequestMapping("/deptAndTeachersStep")
    public Object selectDeptandTeachersStep(){
        Dept dept = dao.selectDeptAndTeachersStep(2);
        System.out.println(dept.toString());
        return dept;
    }

}
