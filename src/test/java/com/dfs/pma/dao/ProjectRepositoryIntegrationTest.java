package com.dfs.pma.dao;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfs.pma.entities.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryIntegrationTest {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("Test Project","Complete","Descripton");
		proRepo.save(newProject);
		
		assertEquals(5, proRepo.findAll().size());
	}

}
