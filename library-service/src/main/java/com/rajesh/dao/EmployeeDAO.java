
 package com.rajesh.dao;
 
 import com.rajesh.model.Employee;
 
 import java.util.List;
 
 
 
 public interface EmployeeDAO {
 
 public void addEmployee(Employee employee);
 public void updateEmployee(Employee employee);
 public List<Employee> getAllEmployees(); 
 public Employee getEmployeeById(Long id);
  public void deleteEmployee(Long id);
  }
