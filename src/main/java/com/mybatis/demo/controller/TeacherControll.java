package com.mybatis.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.demo.entity.Teacher;
import com.mybatis.demo.enums.TeacherStatuesEnum;
import com.mybatis.demo.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("batchSession")
    private SqlSession sqlSession;

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
        System.out.println(teacher1.toString());
        return null;
    }

    @RequestMapping("/ListTeacherByConditons")
    public Object ListTeacherByConditons() {
        Map<String,Object> conditions = new HashMap<String,Object>();
        conditions.put("firstName","ea");
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
        List<Teacher> teachers = getTeachers();
        return dao.insertTeachers(teachers);
    }

    @RequestMapping("/allTeachersByPage")
    public  Object getAllTeachersByPage(){
        PageHelper.startPage(1,2);
        List<Teacher> teachers = dao.allTeacher();
        PageInfo<Teacher> teacherPageInfo = new PageInfo<>(teachers,5);
        System.out.println(teacherPageInfo.getNavigatepageNums());
        return  teacherPageInfo;
    }

    @RequestMapping("/insertTeachersBatch")
    public Object insertTeachersBatch() {
        List<Teacher> teachers = getTeachers();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        return mapper.insertTeachersByBatch(teachers);
    }




    private List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Teacher teacher = new Teacher();
            teacher.setName("teacher" + i);
            teacher.setStatus(TeacherStatuesEnum.LOGIN);
            teachers.add(teacher);
        }
        return teachers;
    }
}
