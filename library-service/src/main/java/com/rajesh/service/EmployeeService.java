 package com.rajesh.service;
 
 import com.rajesh.model.Employee;
 
 import java.util.List;
 
 public interface EmployeeService {
	 public List<Employee> getAllEmployees();
 
 public Employee getEmployeeById(Long id);
 
 public boolean addEmployee(Employee employee);
 
 public boolean updateEmployee(Long id, Employee employee);
 
 public  boolean deleteEmployee(Long id);
}
