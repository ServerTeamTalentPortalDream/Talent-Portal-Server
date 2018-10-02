package com.revature.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.Credentials;
import com.revature.models.User;
import com.revature.services.EmailService;
import com.revature.services.UserService;

@CrossOrigin(origins = "http://revature-1808.cnxwdhy3jnk8.us-west-2.rds.amazonaws.com:5432/postgres")
@RestController
//@JsonIgnoreProperties
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService us;

	@Autowired
	private EmailService es;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User u) {
		ResponseEntity<User> re = new ResponseEntity<User>(u, HttpStatus.CREATED);
		us.createUser(u);
		return re;
	}

	@PostMapping("login")
	public User login(@RequestBody Credentials u) {
		return us.findByUserIdAndPass(u.getUserId(), u.getPass());
	}

	@PostMapping("changePass")
	public void findByUserIdAndEmail(@RequestBody Credentials u) {
		User user = us.findByUserIdAndEmail(u.getUserId(), u.getEmail());
		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("talentportal.server@gmail.com");
		passwordResetEmail.setTo(user.getEmail());

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";
		String values = Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();

		char[] password = new char[10];
		for (int i = 0; i < 10; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
			System.out.println(password);
		}
		passwordResetEmail.setSubject("test");
		passwordResetEmail.setText("temporary password: " + String.copyValueOf(password));
		es.sendEmail(passwordResetEmail);
		user.setPass(String.copyValueOf(password));
		us.saveAndFlush(user);
	}
	
	@PutMapping("resetPassword")
	public String resetPassword(@RequestBody Credentials u) {
		User user = us.findByUserId(u.getUserId());
		if(user.getPass().equals(u.getPass())) {
			return "passwords match";
		}
		
		return "did not match";
	}

	@PutMapping("setPassword")
	public void temporaryPassword(@RequestBody Credentials u) {
		User user = us.findByUserId(u.getUserId());
		user.setPass(u.getPass());
		us.saveAndFlush(user);
	}
	
	@GetMapping
	public List<User> findAll() {
		return us.findAll();
	}

	@GetMapping("{userId}")
	public User findByUserId(@PathVariable int userId) {
		User u = us.findByUserId(userId);
		return u;
	}

	@GetMapping("role/{role}")
	public List<User> findByRole(@PathVariable int role) {
		return us.findByRole(role);
	}
}
