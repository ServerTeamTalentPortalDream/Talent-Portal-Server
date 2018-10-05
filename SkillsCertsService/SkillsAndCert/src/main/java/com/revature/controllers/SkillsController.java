package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Skills;
import com.revature.services.SkillsService;

@CrossOrigin
@RestController
@RequestMapping("skills")
public class SkillsController {

	@Autowired
	private SkillsService ss;
	
	@GetMapping
	public List<Skills> findAll(){
		return ss.findAll();
	}
	
	@GetMapping("{id}")
	public Skills findById(@PathVariable int id) {
		return ss.findById(id);
	}
}
