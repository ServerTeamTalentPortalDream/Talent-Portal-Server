package com.revature.services;

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

	public String uploadResume(String upload, int resourceId) {
		String output = "success";
		long currentDateTime = System.currentTimeMillis();
		Date date = new Date(currentDateTime);
		System.out.println(upload.split("\\\\")[upload.split("\\\\").length-1]);
		String key = date.toString()+"~"+upload.split("\\\\")[upload.split("\\\\").length-1];
//				upload.split("\\")[upload.split("\\").length-1];
		s3.uploadFile(key, upload);
		Resumes resume = new Resumes();
		resume.setResume(key);
		resume.setResourceId(resourceId);
		rr.saveAndFlush(resume);
		return output;
	}

	public String downloadResume(String resume) {
		String home = System.getProperty("user.home");
		System.out.println(resume.split("~")[1]);
		
		s3.downloadFile(resume, home+"\\Downloads\\"+resume.split("~")[1]);
		return resume;
	}

}
