package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Resources;
import com.revature.models.User;
import com.revature.services.ResourcesService;

@CrossOrigin
@RestController
//@JsonIgnoreProperties
@RequestMapping("resources")
public class ResourcesController {
	
	@Autowired
	private ResourcesService rs;
	
	@PostMapping
	public ResponseEntity<Resources> save(@RequestBody Resources r) {
		ResponseEntity<Resources> re = new ResponseEntity<Resources>(r, HttpStatus.CREATED);
		rs.save(r);
		return re;
	}

}
