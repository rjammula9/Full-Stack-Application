
package com.rajesh.service;

import com.rajesh.model.Student;

import java.util.List;

public interface StudentService {
	public List<Student> getAllStudents();

	public Student getStudentById(Long id);

	public boolean addStudent(Student student);

	public boolean updateStudent(Long id,Student student);

	public boolean deleteStudent(Long id);

	
}
