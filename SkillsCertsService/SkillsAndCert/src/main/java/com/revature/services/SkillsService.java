package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.model.Skills;
import com.revature.repos.SkillsRepo;

@Service
public class SkillsService {
	
	@Autowired
	private SkillsRepo sr;
	
	//@HystrixCommand(fallbackMethod = "sendStatusCode")
	public List<Skills> findAll(){
		return sr.findAll();
	}
	
	//@HystrixCommand(fallbackMethod = "sendStatusCode")
	public Skills findById(int id) {
		return sr.getOne(id);
	}

	@SuppressWarnings("unused")
	public ResponseEntity<String> sendStatusCode(){
		return new ResponseEntity<String>("Service is currently unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	}

}
