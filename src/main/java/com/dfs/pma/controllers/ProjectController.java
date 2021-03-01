package com.dfs.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dfs.pma.dao.EmployeeRepository;
import com.dfs.pma.dao.ProjectRepository;
import com.dfs.pma.entities.Employee;
import com.dfs.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> project = proRepo.findAll();
		model.addAttribute("projects",project);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees=empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-projects";
	}
	
	@PostMapping("/save")
	public String createProject(Project project ,Model model) {
		proRepo.save(project);
		
		/*
		 * Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
		 * for(Employee emp : chosenEmployees) { emp.setProject(project);
		 * empRepo.save(emp); }
		 */
		
		// use redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
}
