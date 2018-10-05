package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.UserCerts;
import com.revature.repos.UserCertsRepo;

@Service
public class UserCertsService {
	@Autowired
	private UserCertsRepo ucr;

	public UserCerts save(UserCerts u) {
		return ucr.save(u);

	}
	public UserCerts saveAndFlush(UserCerts u) {
		return ucr.saveAndFlush(u);
	}
}
