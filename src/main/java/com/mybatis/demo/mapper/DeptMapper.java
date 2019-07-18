package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Dept;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper {

    Dept selectDeptById(Integer id);

    Dept selectDeptAndTeachers(Integer id);

    Dept selectDeptAndTeachersStep(Integer id);
}
