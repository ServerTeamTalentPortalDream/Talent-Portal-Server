package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CompetencyTags;
import com.revature.repos.CompetencyRepo;

@Service
public class CompetencyService {
	@Autowired
	private CompetencyRepo cr;
	
	public List<CompetencyTags> findAll() {
		return cr.findAll();
	}

}
