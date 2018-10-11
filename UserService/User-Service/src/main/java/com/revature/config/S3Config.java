package com.revature.config;
 import static com.amazonaws.services.s3.internal.Constants.MB;
 import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
 @Configuration
public class S3Config {
 	@Value("${jsa.aws.access_key_id}")
	private String awsId;
 	@Value("${jsa.aws.secret_access_key}")
	private String awsKey;
 	@Value("${jsa.s3.region}")
	private String region;
 	@Value("${jsa.s3.bucket}")
	private String bucketName;
 	private Logger logger = LoggerFactory.getLogger(S3Config.class);
 	@Bean
	public AmazonS3 s3client() {
 		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
 		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
 		return s3Client;
	}
 	@Bean
	public TransferManager transferManager() {
 		TransferManager tm = TransferManagerBuilder.standard().withS3Client(s3client())
				.withDisableParallelDownloads(false).withMinimumUploadPartSize(Long.valueOf(5 * MB))
				.withMultipartUploadThreshold(Long.valueOf(16 * MB)).withMultipartCopyPartSize(Long.valueOf(5 * MB))
				.withMultipartCopyThreshold(Long.valueOf(100 * MB)).withExecutorFactory(() -> createExecutorService(20))
				.build();
 		int oneDay = 1000 * 60 * 60 * 24;
		Date oneDayAgo = new Date(System.currentTimeMillis() - oneDay);
 		try {
 			tm.abortMultipartUploads(bucketName, oneDayAgo);
 		} catch (AmazonClientException e) {
			logger.error("Unable to upload file, upload was aborted, reason: " + e.getMessage());
		}
 		return tm;
	}
 	private ThreadPoolExecutor createExecutorService(int threadNumber) {
		ThreadFactory threadFactory = new ThreadFactory() {
			private int threadCount = 1;
 			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName("jsa-amazon-s3-transfer-manager-worker-" + threadCount++);
				return thread;
			}
		};
		return (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNumber, threadFactory);
	}
}