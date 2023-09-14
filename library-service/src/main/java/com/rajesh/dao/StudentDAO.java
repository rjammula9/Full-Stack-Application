
  package com.rajesh.dao;
  
 import com.rajesh.model.Student;
  
  import java.util.List;
  
  public interface StudentDAO {
	  public List<Student> getAllStudents();
	  public Student getStudentById(Long id); 
	  public void addStudent(Student student);
	  public void updateStudent(Student student); 
	  public void deleteStudent(Long id);

	  }
 