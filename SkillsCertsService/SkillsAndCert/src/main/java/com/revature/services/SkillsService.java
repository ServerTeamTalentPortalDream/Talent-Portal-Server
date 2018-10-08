package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Skills;
import com.revature.repos.SkillsRepo;

@Service
public class SkillsService {
	
	@Autowired
	private SkillsRepo sr;
	
	public List<Skills> findAll(){
		return sr.findAll();
	}
	
	public Skills findById(int id) {
		return sr.getOne(id);
	}

}
