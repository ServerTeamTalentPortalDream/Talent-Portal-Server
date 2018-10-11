package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Skills;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Integer> {

}
