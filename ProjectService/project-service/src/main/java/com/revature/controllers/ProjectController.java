package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody(required=false) Project p) {
		int id = ps.save(p);
		ResponseEntity<Integer> resp = new ResponseEntity<Integer>(id, HttpStatus.CREATED);
		return resp;
	}

}