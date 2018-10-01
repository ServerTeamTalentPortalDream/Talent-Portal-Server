package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Certifications;
import com.revature.services.CertifiactionsService;

@CrossOrigin
@RestController
@RequestMapping("certifications")
public class CertificationsController {

	@Autowired
	private CertifiactionsService cs;
	
	@GetMapping
	public List<Certifications> findAll(){
		return cs.findAll();
	}
	
	@GetMapping("{id}")
	public Certifications findById(@PathVariable int id) {
		return cs.findById(id);
	}
}
