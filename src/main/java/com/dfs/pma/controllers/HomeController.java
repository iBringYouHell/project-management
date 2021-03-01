package com.dfs.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dfs.pma.dao.EmployeeRepository;
import com.dfs.pma.dao.ProjectRepository;
import com.dfs.pma.dto.ChartData;
import com.dfs.pma.dto.EmployeeProject;
import com.dfs.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
	
	// querying DB for projects
	List<Project> projects = proRepo.findAll();
	model.addAttribute("projectList",projects);
	
	List<ChartData> projectData = proRepo.getProjectStatus();
	
	// convert projectData object into json for JS
	/*
	 * ObjectMapper objectMapper = new ObjectMapper(); String jsonString =
	 * objectMapper.writeValueAsString(projectData);
	 * model.addAttribute("projectStatusCnt",jsonString);
	 */
	
	//querying DB for employee
	List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
	model.addAttribute("employeesProjectCnt",employeesProjectCnt);
	
	return "main/home";	
	}

}
