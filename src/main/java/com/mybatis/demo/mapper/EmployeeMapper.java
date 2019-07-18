package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeMapper {
    int insert(Employee employee);
    int update(Employee employee);
    int delete(Integer id);
    Employee selectByConditions(@Param("id") Integer id, @Param("name") String name);

    List<Employee> allEmployees();


    @MapKey(value = "id")
    Map<Integer, Employee> allEmpMap();
}
