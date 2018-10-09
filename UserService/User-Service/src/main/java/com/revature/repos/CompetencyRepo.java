package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.CompetencyTags;

public interface CompetencyRepo extends JpaRepository <CompetencyTags, Integer>{

}
