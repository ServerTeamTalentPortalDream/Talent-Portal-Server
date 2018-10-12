package com.revature.controllers;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 import com.revature.models.Resumes;
import com.revature.services.ResumeService;
 @CrossOrigin
@RestController
@RequestMapping("resume")
public class ResumeController {
	
	@Autowired
	ResumeService rs;
	
	@PostMapping("{resourceId}")
	public String uploadResume(@RequestBody Resumes resume, @PathVariable int resourceId) {
		return rs.uploadResume(resume.getResume(), resourceId);	
	}
	
	@PostMapping
	public String downloadResume(@RequestBody Resumes resume) {
		return rs.downloadResume(resume.getResume());	
	}
 } 