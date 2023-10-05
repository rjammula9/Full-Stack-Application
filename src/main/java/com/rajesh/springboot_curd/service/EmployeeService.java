package com.rajesh.springboot_curd.service;

import com.rajesh.springboot_curd.model.Employee;

import java.util.List;

public interface EmployeeService {
    List < Employee > getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
