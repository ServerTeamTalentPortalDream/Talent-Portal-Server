package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.model.Certifications;
import com.revature.repos.CertificationsRepo;

@Service
public class CertifiactionsService {
	
	@Autowired
	private CertificationsRepo cr; 
	
	//@HystrixCommand(fallbackMethod = "sendStatusCode")
	public List<Certifications> findAll(){
		return cr.findAll();
	}
	
	//@HystrixCommand(fallbackMethod = "sendStatusCode")
	public Certifications findById(int id) {
		return cr.getOne(id);		
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<String> sendStatusCode(){
		return new ResponseEntity<String>("Service is currently unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	}

}
