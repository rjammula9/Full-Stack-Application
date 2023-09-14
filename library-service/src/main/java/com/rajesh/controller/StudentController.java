
  package com.rajesh.controller;
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rajesh.model.Book;
import com.rajesh.model.Student;
import com.rajesh.service.StudentService;
  
  @Controller
  @RequestMapping("/students")
  public class StudentController {
  
  @Autowired
  private StudentService studentService; 
  public StudentController(StudentService studentService) {
	  this.studentService =studentService;
  }
  
  @GetMapping("/getAll")
  public String listStudents(Model model) {
	  List<Student> students =studentService.getAllStudents();
	  model.addAttribute("students", students);
	  return "student/list";
  }
  
  @GetMapping
  public String getJsp(Model model) {
	  List<Student> students =studentService.getAllStudents();
	  model.addAttribute("students", students);
	  return "students"; 
  }
  @GetMapping("/student/add")
  public String showAddForm(Model model) {
	  model.addAttribute("student",new Student());
	  return "student/add";
  }
  @PostMapping("/student/add")
  public ModelAndView addBook(@ModelAttribute("student") Student student) {
	  ModelAndView modelandview = new ModelAndView("/students");
	  studentService.addStudent(student);
	  List<Student> s=studentService.getAllStudents();
	  System.out.println("controller student objects " + s);
	 modelandview.addObject("students",s);
	 return modelandview;
  }
  @GetMapping("/student/edit/{id}")
  public ModelAndView showEditFrom(@PathVariable("id") Long id) {
	  ModelAndView modelAndView =new ModelAndView("student/edit");
	  Student student =studentService.getStudentById(id);
	  modelAndView.addObject("student",student);
	  return modelAndView;
  }
  
	@PutMapping("/student/edit/{id}")
	public ModelAndView editBook(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
		ModelAndView modelAndView = new ModelAndView("redirect:/students"); // Redirect
		if (studentService.updateStudent(id, student)) {
			return modelAndView;
		}
		return modelAndView;
	}
	@GetMapping("/student/delete/{id}")
	public ModelAndView showDeleteConfirmation(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("student/delete");
		Student student= studentService.getStudentById(id);
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	@DeleteMapping("/student/delete/{id}")
	public ModelAndView deleteStudent(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/students");
		studentService.deleteStudent(id);
		return modelAndView;
	}
}
