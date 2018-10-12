package com.revature.services;
 import java.io.File;
import java.util.Arrays;
import java.util.Date;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import com.revature.models.Resumes;
import com.revature.repos.ResumeRepo;
 //import com.revature.repos.ResumeRepo;
 @Service
public class ResumeService {
 	@Autowired
	private ResumeRepo rr;
 	@Autowired
	private S3Service s3;
 	public int uploadResume(File upload) {
		long currentDateTime = System.currentTimeMillis();
		Date date = new Date(currentDateTime);
		String key = date.toString()+"~"+upload.getName();
		s3.uploadFile(key, upload);
		Resumes resume = new Resumes();
		resume.setResume(key);
		resume.setResourceId(1);
	rr.saveAndFlush(resume);
		return rr.saveAndFlush(resume).getId();
	}
 	public File downloadResume(String resume) {
		String home = System.getProperty("user.home");
		  s3.downloadFile(resume, home+"\\Downloads\\"+resume.split("~")[1]);
		return new File(home+"\\Downloads\\"+resume.split("~")[1]);
	}
 }