package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Grades;
import com.revature.repos.GradesRepo;

@Service
public class GradesService {
	@Autowired
	private GradesRepo gr;
	
	public List<Grades> findAll() {
		return gr.findAll();
	}

}
