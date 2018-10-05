package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Certs;
import com.revature.repos.CertsRepo;

@Service
public class CertsService {

	@Autowired
	private CertsRepo cr;

	public Certs save(Certs u) {
		return cr.save(u);
	}
	public Certs saveAndFlush(Certs u) {
		return cr.saveAndFlush(u);
	}
}
