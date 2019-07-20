package com.mybatis.demo.controller;

import com.mybatis.demo.entity.Teacher;
import com.mybatis.demo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TeacherControll {
    @Autowired
    private TeacherMapper dao;

    @RequestMapping("/allTeacherInfo")
    public  Object getAllTeachers(){
        return  dao.allTeacher();
    }

    @RequestMapping("/selectTeacherAndDept")
    public Object getTeacherAndDept() {
        return dao.selectTeacherAndDept(2);
    }

    @RequestMapping("/stepSelect")
    public Object setpSelect() {
        return dao.selectTeacherAndDeptStep(2);
    }

    @RequestMapping("/listDeptTeachers")
    public Object listDeptTeachers() {
        return dao.selectTeacherByDeptNum(2);
    }


    @RequestMapping("/listTeacherDesc")
    public Object listTeacherDesc() {
        Teacher teacher1 = dao.selectTeacherById(2);
        Teacher teacher2 = dao.selectTeacherById(4);
        return null;
    }
}
