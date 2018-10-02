package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo ur;
		
	
//	public User findByUsername(String userId) {
//		return ur.findByUsername(username);
//	}
	
	public List<User> findAll(){
		return ur.findAll();
	}
	public User findByUserId(int userId) {
		User u = ur.findByUserId(userId);
		return u;
	}
	public User findByUserIdAndPass(int userId, String pass) {
		return ur.findByUserIdAndPass(userId, pass);
	}
	public User findByUserIdAndEmail(int userId, String email) {
		return ur.findByUserIdAndEmail(userId, email);
	}
	public List<User> findByRole(int role){
		return ur.findByRole(role);
	}
	public User createUser(User u) {
		return ur.save(u);
	}
	public void saveAndFlush(User user) {
		ur.saveAndFlush(user);
	}

}
