package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.UserSkills;
import com.revature.repos.UserSkillsRepo;

@Service
public class UserSkillsService {

	@Autowired
	private UserSkillsRepo usr;

	public UserSkills save(UserSkills u) {
		return usr.save(u);
	}
	public UserSkills saveAndFlush(UserSkills u) {
		return usr.saveAndFlush(u);
	}
	public List<UserSkills> findAll(){
		return usr.findAll();
	}
}
