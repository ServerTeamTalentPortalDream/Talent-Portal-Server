package com.revature.repos;
 import java.io.File;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 import com.revature.models.Resumes;
 @Repository
public interface ResumeRepo extends JpaRepository <Resumes, Integer>{

	void saveAndFlush(ArrayList<Resumes> res);
 	
}