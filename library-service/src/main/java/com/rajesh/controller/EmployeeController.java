 package com.rajesh.controller;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.servlet.ModelAndView;


import com.rajesh.model.Employee;

import com.rajesh.service.EmployeeService;
import java.util.List;
 
 
  @Controller
 @RequestMapping("/employees")
  public class EmployeeController {
	  @Autowired 
  private EmployeeService employeeService;
  
	  public EmployeeController(EmployeeService employeeService) {
			this.employeeService = employeeService;
		}
	  @GetMapping("/getAll")
		public String listEmployees(Model model) {
			List<Employee> employees = employeeService.getAllEmployees();
			System.out.println("Employees in controller:" + employees);
			model.addAttribute("employees", employees);
			return "employee/list";
		}
		@GetMapping
		public String getJsp(Model model) {
			List<Employee> employees = employeeService.getAllEmployees();
			model.addAttribute("employees", employees);
			return "employees";
		}


		// GET Request to show a form for adding a new book

		@GetMapping("/employee/add")
		public String showAddForm(Model model) {
			model.addAttribute("employee", new Employee());
			return "employee/add";
		}

		// POST Request to add a new book

		@PostMapping("/employee/add")
		public ModelAndView addBook(@ModelAttribute("employee") Employee employee) {
			ModelAndView modelandview = new ModelAndView("/employees");
			employeeService.addEmployee(employee);
			List<Employee> e =employeeService.getAllEmployees();
			System.out.println("controller book objects " + e);
			modelandview.addObject("employees", e);
			return modelandview;
		}

		@GetMapping("/employee/edit/{id}")
		public ModelAndView showEditForm(@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView("employee/edit");
			Employee employee = employeeService.getEmployeeById(id);
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}

		@PutMapping("/employee/edit/{id}")
		public ModelAndView editEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
			ModelAndView modelAndView = new ModelAndView("redirect:/employees"); // Redirect
			if (employeeService.updateEmployee(id, employee)) {
				return modelAndView;
			}
			return modelAndView;
		}

		@GetMapping("/employee/delete/{id}")
		public ModelAndView showDeleteConfirmation(@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView("employee/delete");
			Employee employee = employeeService.getEmployeeById(id);
			modelAndView.addObject("employee", employee);
			return modelAndView;
		}

		@DeleteMapping("/employee/delete/{id}")
		public ModelAndView deleteBook(@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/employees");
			employeeService.deleteEmployee(id);
			return modelAndView;
		}
	}
