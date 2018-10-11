//package com.revature.controllers;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.revature.services.S3Service;
// 
//@SpringBootApplication
//public class S3Controller implements CommandLineRunner{
// 
//	
//	@Autowired
//	S3Service s3Service;
//	
//	@Value("${jsa.s3.uploadfile}")
//	private String uploadFilePath;
//	
//	@Value("${jsa.s3.downloadfile}")
//	private String downloadFilePath;
//	
//	@Value("${jsa.s3.key}")
//	private String key;
// 
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("---------------- START UPLOAD FILE ----------------");
//		s3Services.uploadFile(key, upload);
//		System.out.println("---------------- START DOWNLOAD FILE ----------------");
//		s3Services.downloadFile(key, downloadFilePath);
//		System.out.println("DONE!");
//	}
//}