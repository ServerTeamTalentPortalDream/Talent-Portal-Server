
package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Project;
import com.revature.repos.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository pr;

	public int save(Project p) {
		return pr.saveAndFlush(p).getProjectId();
	}
	
	public List<Project> findAll() {
		return pr.findAll();
	}

}