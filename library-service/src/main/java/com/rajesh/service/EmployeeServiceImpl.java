
 package com.rajesh.service;
 
 import com.rajesh.dao.EmployeeDAO;
import com.rajesh.model.Book;
import com.rajesh.model.Employee;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.stereotype.Service;
  import java.util.List;
  import javax.transaction.Transactional;
  
 @Service
 @Transactional
 public class EmployeeServiceImpl implements EmployeeService {
	 @Autowired	 
 private EmployeeDAO employeeDAO;
  
	  @Override
	    public List<Employee> getAllEmployees() {
	        return employeeDAO.getAllEmployees();
	    }

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return employeeDAO.getEmployeeById(id);
	    }

	    @Override
	    public boolean addEmployee(Employee employee) {
	        try {
	        	employeeDAO.addEmployee(employee);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean updateEmployee(Long id, Employee employee) {
	        try {
	        	employee.setId(id);
	        	employeeDAO.updateEmployee(employee);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean deleteEmployee(Long id) {
	        try {
	        	employeeDAO.deleteEmployee(id);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}