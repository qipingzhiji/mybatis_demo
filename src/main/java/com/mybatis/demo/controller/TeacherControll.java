package com.mybatis.demo.controller;

import com.mybatis.demo.entity.Teacher;
import com.mybatis.demo.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/ListTeacherByConditons")
    public Object ListTeacherByConditons() {
        Map<String,Object> conditions = new HashMap<String,Object>();
        conditions.put("sex", "1");
        List<Teacher> teachers = dao.listTeacherByConditon(conditions);
        return teachers;
    }

    @RequestMapping("/updateTeacherById")
    public Object updateTeacherById() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setSex(2);
        return dao.updateTeacherById(teacher) > 0;
    }

    @RequestMapping("/selectByIds")
    public Object selectTeachersByIds() {
        List<Teacher> teachers = dao.selectTeachersByIds(new Integer[]{1, 2, 4});
        teachers.forEach(t->{
            System.out.println( t);
        });
        return true;
    }

    @RequestMapping("/insertTeachers")
    public Object insertTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher1 = new Teacher();
        teacher1.setName("teacher1");
        Teacher teacher2 = new Teacher();
        teacher2.setName("teacher2");
        teachers.add(teacher1);
        teachers.add(teacher2);
        return dao.insertTeachers(teachers);
    }
}
