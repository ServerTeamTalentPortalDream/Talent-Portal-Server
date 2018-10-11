package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.SkillGroup;

@Repository
public interface SkillGroupRepo extends JpaRepository<SkillGroup, Integer>{
	
}