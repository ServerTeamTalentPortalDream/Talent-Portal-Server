package com.revature.repos;

import org.springframework.mail.SimpleMailMessage;

public interface EmailRepo {
	public void sendEmail(SimpleMailMessage email);

}
