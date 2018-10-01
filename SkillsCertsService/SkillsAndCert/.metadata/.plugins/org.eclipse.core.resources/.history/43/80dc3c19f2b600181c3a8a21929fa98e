package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.AppUser;
import com.revature.projections.BasicUserProjection;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Integer> {
	BasicUserProjection findByUsernameAndPassword(String username, String password);

	List<AppUser> findByMoviesId(int id);

	List<BasicUserProjection> findAllProjectedBy();

}
