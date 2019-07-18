package com.mybatis.demo.controller;

import com.mybatis.demo.entity.Employee;
import com.mybatis.demo.mapper.EmployeeMapper;
import com.mybatis.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeMapper dao;

    @RequestMapping("/insert")
    public  Object insert(Employee employee) {
        employee.setName("admin");
        employee.setAge(18);
        employee.setBirth(new Date());
        service.insert(employee);
        return employee;
    }

    @RequestMapping("/update")
    public Object update(Employee employee) {
        employee.setAge(25);
        employee.setId(1);
        return  service.update(employee);
    }

    @RequestMapping("/delete")
    public Object delete(Integer id) {
        id = 1;
        return service.delete(id);
    }

    @RequestMapping("/selectByConditons")
    public Object selectByConditons(){
        return service.selectByConditions(2,"admin");
    }

    @RequestMapping("/allEmp")
    public Object allEmployees() {
        return service.allEmployees();
    }

    @RequestMapping("/allEmpMap")
    public Object allEmpMap(){
        return dao.allEmpMap();
    }
}
