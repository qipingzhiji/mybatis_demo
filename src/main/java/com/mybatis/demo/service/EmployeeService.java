package com.mybatis.demo.service;

import com.mybatis.demo.entity.Employee;
import com.mybatis.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper dao;

    public  boolean insert(Employee employee) {
        return dao.insert(employee) > 0;
    }

    public boolean update(Employee employee) {
        return dao.update(employee)>0;
    }

    public boolean delete(Integer id) {
        return dao.delete(id)>0;
    }

    public Employee selectByConditions(Integer id, String name) {
        return  dao.selectByConditions(id,name);
    }

    public List<Employee> allEmployees() {
        return  dao.allEmployees();
    }
}
