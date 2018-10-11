package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	Optional<Project> findByProjectId(int projectId);
	List<Project> findAllByOrderByStartDate();
}