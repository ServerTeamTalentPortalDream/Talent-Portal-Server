package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Resources;

@Repository
public interface ResourcesRepo extends JpaRepository <Resources, Integer>{

}
