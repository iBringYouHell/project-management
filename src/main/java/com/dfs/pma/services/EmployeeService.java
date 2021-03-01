package com.dfs.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.pma.dao.EmployeeRepository;
import com.dfs.pma.dto.EmployeeProject;
import com.dfs.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}

	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}
}
