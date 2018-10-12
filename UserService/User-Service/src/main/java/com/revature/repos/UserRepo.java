package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepo extends JpaRepository <User, Integer>{

//	User findByUsername(String username);
	Optional<User> findByUserId(int userId);
	User findByUserIdAndPass(int userId, String pass);
	User findByUserIdAndEmail(int userId, String email);
	User findByAssociateId(int associateId);
	List<User> findByRole(int role);
}
