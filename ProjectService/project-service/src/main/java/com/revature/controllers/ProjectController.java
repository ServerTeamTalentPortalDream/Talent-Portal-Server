package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	@Autowired
	private ProjectService ps;
	
	@GetMapping
	public List<Project> findAll(){
		List<Project> projects = ps.findAll();
		return projects;
	}
	@GetMapping("hello")
	public String greeting() {
		return "hello, there.";
	}
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody(required=false) Project p) {
		int id = ps.save(p);
		ResponseEntity<Integer> resp = new ResponseEntity<Integer>(id, HttpStatus.CREATED);
		return resp;
	}
	
	//finds a project by id
	@Transactional
	@GetMapping("{id}")
	public Project findById(@PathVariable int id) {
		Project project = ps.findOne(id);
		return project;
	}
	
	@GetMapping("/recent")
	public Project[] findRecentProjects() {
		return ps.findRecent3();
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