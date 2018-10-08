package com.revature.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.revature.repos.EmailRepo;

@Service("es")
public class EmailService implements EmailRepo {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
	   JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	   mailSender.setHost("smtp.gmail.com");
	   mailSender.setPort(587);

	   mailSender.setUsername("talentportal.server@gmail.com");
	   mailSender.setPassword("cognizant");

	   Properties props = mailSender.getJavaMailProperties();
	   props.put("mail.transport.protocol", "smtp");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.debug", "true");

	   return mailSender;
	}
}
