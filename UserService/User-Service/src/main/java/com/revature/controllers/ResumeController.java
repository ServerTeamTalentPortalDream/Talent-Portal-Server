package com.revature.controllers;
 import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Resumes;
import com.revature.services.ResumeService;
@CrossOrigin
@RestController
@RequestMapping("resume")
public class ResumeController {
	
	@Autowired
	ResumeService rs;
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		   File convFile = new File(file.getOriginalFilename());
		   FileOutputStream fos = new FileOutputStream(convFile);
		   fos.write(file.getBytes());
		   fos.close();
		   return convFile;
		}
	
	@PostMapping("upload")
	public int uploadResume(@RequestPart(value ="file") MultipartFile file) {
		File fil=null;
		try {
			fil = convertMultiPartToFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs.uploadResume(fil);	
	}
	
	@PostMapping
	public File downloadResume(@RequestBody Resumes resume) {
		return rs.downloadResume(resume.getResume());	
	}
 } 