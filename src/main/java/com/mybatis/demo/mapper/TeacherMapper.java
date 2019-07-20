package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    List<Teacher> allTeacher();


    List<Teacher> selectTeacherAndDept(Integer id);


    List<Teacher> selectTeacherAndDeptStep(Integer id);

    List<Teacher> selectTeacherByDeptNum(@Param("deptNum") Integer deptNum);

    Teacher selectTeacherById(Integer id);
}
