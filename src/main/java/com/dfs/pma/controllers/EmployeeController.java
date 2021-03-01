package com.dfs.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfs.pma.dao.EmployeeRepository;
import com.dfs.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository emp;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = emp.findAll();
		model.addAttribute("employees",employees);
		return "employees/list-employee";
	}
	
	@GetMapping("/new")
	public String displayEmployee(Model model) {
	
		Employee empl = new Employee();
		model.addAttribute("employee",empl);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(Employee employee, Model model) {
	emp.save(employee);
		return "redirect:/employees/new";
	}

}
