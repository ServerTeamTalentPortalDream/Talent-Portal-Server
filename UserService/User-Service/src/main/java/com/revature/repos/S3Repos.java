package com.revature.repos;
 import java.io.File;
import java.io.IOException;
 import org.springframework.web.multipart.MultipartFile;
 public interface S3Repos {
	
	public void uploadFile(String keyName, File upload);
	public void downloadFile(String keyName, String downloadFilePath);
}