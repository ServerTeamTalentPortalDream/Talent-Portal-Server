package com.revature.services;
 import java.io.File;
import java.io.FileOutputStream;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
 import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.revature.repos.S3Repos;
 @Service
public class S3Service implements S3Repos {
 	protected Logger logger = LoggerFactory.getLogger(S3Service.class);
 	@Autowired
	protected TransferManager transferManager;
 	@Value("${jsa.s3.bucket}")
	protected String bucketName;
 	/**
	 * UPLOAD FILE to Amazon S3
	 */
	@Override
	public void uploadFile(String keyName, File upload) {
	
		final PutObjectRequest request = new PutObjectRequest(bucketName, keyName, upload);
 		request.setGeneralProgressListener(new ProgressListener() {
			@Override
			public void progressChanged(ProgressEvent progressEvent) {
				String transferredBytes = "Uploaded bytes: " + progressEvent.getBytesTransferred();
				logger.info(transferredBytes);
			}
		});
 		Upload uploaded = transferManager.upload(request);
 		// Or you can block and wait for the upload to finish
		try {
 			uploaded.waitForCompletion();
 		} catch (AmazonServiceException e) {
			logger.info(e.getMessage());
		} catch (AmazonClientException e) {
			logger.info(e.getMessage());
		} catch (InterruptedException e) {
			logger.info(e.getMessage());
		}
	}
 	/**
	 * DOWNLOAD FILE from Amazon S3
	 */
	@Override
	public void downloadFile(String keyName, String downloadFilePath) {
		final GetObjectRequest request = new GetObjectRequest(bucketName, keyName);
 		request.setGeneralProgressListener(new ProgressListener() {
			@Override
			public void progressChanged(ProgressEvent progressEvent) {
				String transferredBytes = "Downloaded bytes: " + progressEvent.getBytesTransferred();
				logger.info(transferredBytes);
			}
		});
 		Download download = transferManager.download(request, new File(downloadFilePath));
 		try {
 			download.waitForCompletion();
 		} catch (AmazonServiceException e) {
			logger.info(e.getMessage());
		} catch (AmazonClientException e) {
			logger.info(e.getMessage());
		} catch (InterruptedException e) {
			logger.info(e.getMessage());
		}
	}
} 