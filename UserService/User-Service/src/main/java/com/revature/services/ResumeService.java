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
		String key = date.toString()+"resume.rar";
		s3.uploadFile(key, upload);
		Resumes resume = new Resumes();
		resume.setResume(key);
		resume.setResourceId(resourceId);
		rr.saveAndFlush(resume);
		return output;
	}
 	public String downloadResume(String resume) {
		String home = System.getProperty("user.home");
		String[] split = resume.split("_");
		System.out.println(Arrays.toString(split));
		System.out.println((split[1]));
//		String[] split2 = split[1].split(".");
		String str = split[1].replace(".rar", "");
		System.out.println(str);
		s3.downloadFile(resume, home+"\\Downloads\\" + str + ".png");
		return resume;
	}
 }