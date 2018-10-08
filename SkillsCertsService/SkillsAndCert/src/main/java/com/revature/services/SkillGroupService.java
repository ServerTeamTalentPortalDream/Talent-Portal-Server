package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.SkillGroup;
import com.revature.repos.SkillGroupRepo;

@Service
public class SkillGroupService {

	@Autowired
	private SkillGroupRepo sgr;
	
	public List<SkillGroup> findAll() {
		return sgr.findAll();
	}
	
	public SkillGroup findById(int id) {
		return sgr.getOne(id);
	}
}
