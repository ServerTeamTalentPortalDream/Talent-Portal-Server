package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserSkills;

@Repository
public interface UserSkillsRepo extends JpaRepository < UserSkills, Integer>{

}
