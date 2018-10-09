package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Grades;

public interface GradesRepo extends JpaRepository <Grades, Integer>{

}
