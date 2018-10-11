package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.UserSkills;

@Repository
public interface UserRepo extends JpaRepository <User, Integer>{

//	User findByUsername(String username);
	User findByUserId(int userId);
	User findByUserIdAndPass(int userId, String pass);
	User findByUserIdAndEmail(int userId, String email);
	User findByAssociateId(int associateId);
	List<User> findByRole(int role);
}
