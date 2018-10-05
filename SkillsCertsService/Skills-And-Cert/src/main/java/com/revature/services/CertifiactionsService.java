package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Certifications;
import com.revature.repos.CertificationsRepo;

@Service
public class CertifiactionsService {
	
	@Autowired
	private CertificationsRepo cr; 
	
	public List<Certifications> findAll(){
		return cr.findAll();
	}
	
	public Certifications findById(int id) {
		return cr.getOne(id);		
	}

}
