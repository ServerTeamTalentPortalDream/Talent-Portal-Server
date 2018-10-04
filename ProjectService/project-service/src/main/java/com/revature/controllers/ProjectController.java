package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Project;
import com.revature.service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {

	Logger log = Logger.getRootLogger();
	@Autowired
	private ProjectService ps;
	
	@GetMapping
	public List<Project> findAll(){
		try {
			List<Project> projects = ps.findAll();
			return projects;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
		}
		log.warn("failed to find all");
		return null;
	}
	@GetMapping("hello")
	public String greeting() {
		return "hello, there.";
	}
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody(required=false) Project p) {
		try {
			int id = ps.save(p);
			ResponseEntity<Integer> resp = new ResponseEntity<Integer>(id, HttpStatus.CREATED);
			return resp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
		}
		log.warn("failed create new project");
		return null;
	}
	
	//finds a project by id
	@Transactional
	@GetMapping("{id}")
	public Project findById(@PathVariable int id) {
		try {
			Project project = ps.findOne(id);
			return project;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
		}
		log.warn("failed to find project by id");
		return null;
	}
	
	@GetMapping("/recent")
	public Project[] findRecentProjects() {
		try {
			return ps.findRecent3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
		}
		log.warn("failed to find recent projects");
		return null;
	}
	
	//Patches a project if it already exists and responds with 404 if it does not
	@PatchMapping
	public  ResponseEntity<Project> updateUser(@RequestBody Project p) {
		Optional<Project> respBody = ps.Update(p);
		if(respBody.isPresent()) {
			return new ResponseEntity<Project>(respBody.get(),HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Project>(p,HttpStatus.BAD_REQUEST);
		}
	}
}