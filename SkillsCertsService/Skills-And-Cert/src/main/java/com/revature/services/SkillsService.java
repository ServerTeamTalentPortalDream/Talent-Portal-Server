package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Skills;
import com.revature.repos.SkillsRepo;

@Service
public class SkillsService {

	@Autowired
	private SkillsRepo sr;

	public Skills save(Skills u) {
		return sr.save(u);

	}
	public Skills saveAndFlush(Skills u) {
		return sr.saveAndFlush(u);
	}
}
