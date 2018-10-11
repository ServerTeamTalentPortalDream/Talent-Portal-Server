
package com.revature.service;

import java.sql.Date;
import java.util.Calendar;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.model.Project;
import com.revature.repos.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository pr;
	
	@HystrixCommand(fallbackMethod = "saveFallback")
	public int save(Project p) {
		System.out.println(p.getStartDate());
		if (p.getStartDate() ==null) {
			p.setStartDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		}
		return pr.saveAndFlush(p).getProjectId();
	}
	
	@HystrixCommand(fallbackMethod = "findAllFallback")
	public List<Project> findAll() {
		return pr.findAll();
		
	}
	
	@HystrixCommand(fallbackMethod = "findOneFallback")
	public Project findOne(int id) {
		Project p = pr.getOne(id);
		return p;
	}
	
	@HystrixCommand(fallbackMethod = "findRecent3Fallback")
	public Project[] findRecent3() {
		Project[] recents = new Project[3];
		List<Project> orderedProjects = pr.findAllByOrderByStartDate();
		for (int i = 0; i<3;i++) {
			recents[i] = orderedProjects.get(i);
		}
		return recents;
	}
	
	@HystrixCommand(fallbackMethod = "updateProjectFallback")
	public Optional<Project> updateProject(Project newProject) {

		Optional<Project> oldProject = pr.findByProjectId(newProject.getProjectId());
		oldProject.ifPresent(project -> {
		
			if(newProject.getCustomer() != null) {
				project.setCustomer(newProject.getCustomer());
			}
			if(newProject.getName() != null) {
				project.setName( newProject.getName());
			}
			if(newProject.getStartDate() != null) {
				project.setStartDate(newProject.getStartDate());
			}
			if(newProject.getEndDate() != null) {
				project.setEndDate( newProject.getEndDate());
			}
			if(newProject.getDescription() != null) {
				project.setDescription( newProject.getDescription());
			}
			if(newProject.getSupervisorId() != 0) {
				project.setSupervisorId( newProject.getSupervisorId());
			}
			if(newProject.getLocation() != null) {
				project.setLocation( newProject.getLocation());
			}
			pr.saveAndFlush(project);
		});
			return oldProject;

				
	}
	

	public void deleteProject(int id) {
		pr.delete(id);
	}
	
	@SuppressWarnings("unused")
	public int saveFallback(Project p){
		return 0;
	}
	
	@SuppressWarnings("unused")
	public List<Project> findAllFallback(){
		List<Project> p = null;
		return p;
	}
	
	@SuppressWarnings("unused")
	public Project findOneFallback(int id){
		Project p = null;
		return p;
	}
	
	@SuppressWarnings("unused")
	public Project[] findRecent3Fallback(){
		Project[] p = null;
		return p;
	}
	
	@SuppressWarnings("unused")
	public Optional<Project> updateProjectFallback(Project newProject){
		Optional<Project> p = null;
		return p;
	}
	
}
