package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.AppUser;
import com.revature.projections.BasicUserProjection;
import com.revature.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo ur;

	public List<BasicUserProjection> findAll() {
		return ur.findAllProjectedBy();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public AppUser findOne(int id) {
		AppUser u = ur.getOne(id);
		return u;
	}

	public BasicUserProjection login(String username, String password) {
		return ur.findByUsernameAndPassword(username, password);
	}

	public List<AppUser> findByMoviesId(int id) {
		return ur.findByMoviesId(id);
	}
}
