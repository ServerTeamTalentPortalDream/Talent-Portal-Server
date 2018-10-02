package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.SkillGroup;
import com.revature.services.SkillGroupService;

@CrossOrigin
@RestController
@RequestMapping("skill-group")
public class SkillGroupContoller {

	@Autowired
	private SkillGroupService sgs;
	
	@GetMapping
	public List<SkillGroup> findAll() {
		return sgs.findAll();
	}
	
	@GetMapping("{id}")
	public SkillGroup findById(@PathVariable int id) {
		return sgs.findById(id);
	}
}
