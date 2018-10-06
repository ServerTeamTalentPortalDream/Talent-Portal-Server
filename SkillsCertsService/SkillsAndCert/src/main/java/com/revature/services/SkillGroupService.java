package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.model.SkillGroup;
import com.revature.repos.SkillGroupRepo;

@Service
public class SkillGroupService {

	@Autowired
	private SkillGroupRepo sgr;
	
	//@HystrixCommand(fallbackMethod = "sendStatusCode")
	public List<SkillGroup> findAll() {
		return sgr.findAll();
	}
	
	//@HystrixCommand(fallbackMethod = "sendStatusCode")
	public SkillGroup findById(int id) {
		return sgr.getOne(id);
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<String> sendStatusCode(){
		return new ResponseEntity<String>("Service is currently unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	}

}
