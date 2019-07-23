package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherMapper {

    List<Teacher> allTeacher();


    List<Teacher> selectTeacherAndDept(Integer id);


    List<Teacher> selectTeacherAndDeptStep(Integer id);

    List<Teacher> selectTeacherByDeptNum(@Param("deptNum") Integer deptNum);

    Teacher selectTeacherById(Integer id);


    List<Teacher> listTeacherByConditon(Map<String, Object> conditions);

    int updateTeacherById(Teacher teacher);

    List<Teacher> selectTeachersByIds(@Param("ids") Integer[] ids);


    int insertTeachers(@Param("teachers") List<Teacher> teachers);

    int insertTeachersByBatch(@Param("teachers") List<Teacher> teachers);

}