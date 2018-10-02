
package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Project findOne(int id) {
		Project p = pr.getOne(id);
		return p;
	}
//	public Project[] findRecent() {
//		Project[] recents = new Project[3];
//		
//	}
	public Optional<Project> Update(Project newProject) {

		Optional<Project> oldProject = pr.findById(newProject.getProjectId());
		oldProject.ifPresent(project -> {
			if(newProject.getCompetency() != null) {
				project.setCompetency(newProject.getCompetency());
			}
			if(newProject.getCustomer() != null) {
				project.setCustomer(newProject.getCustomer());
			}
			if(newProject.getProjectName() != null) {
				project.setProjectName( newProject.getProjectName());
			}
			if(newProject.getStartDate() != null) {
				project.setStartDate(newProject.getStartDate());
			}
			if(newProject.getEndDate() != null) {
				project.setEndDate( newProject.getEndDate());
			}
			if(newProject.getDetails() != null) {
				project.setDetails( newProject.getDetails());
			}
			if(newProject.getSupervisor() != null) {
				project.setSupervisor( newProject.getSupervisor());
			}
			if(newProject.getSupervisorId() != 0) {
				project.setSupervisorId( newProject.getSupervisorId());
			}
			if(newProject.getProjectLocation() != null) {
				project.setProjectLocation( newProject.getProjectLocation());
			}
			pr.saveAndFlush(project);
		});
			return oldProject;

				
	}
}