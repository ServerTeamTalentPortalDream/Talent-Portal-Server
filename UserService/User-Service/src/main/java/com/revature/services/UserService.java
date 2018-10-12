package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo ur;
	

	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	
//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}
	
//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public static String generateSecurePassword(String password, String salt) {
		String returnValue = null;
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		returnValue = Base64.getEncoder().encodeToString(securePassword);
		return returnValue;
	}
	
//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
		boolean returnValue = false;
		// Generate New secure password with the same salt
		String newSecurePassword = generateSecurePassword(providedPassword, salt);
		// Check if two passwords are equal
		returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
		return returnValue;
	}

//	public User findByUsername(String userId) {
//		return ur.findByUsername(username);
//	}
	
//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public List<User> findAll() {
		return ur.findAll();
	}

//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public User findByUserId(int userId) {
		Optional<User> u = ur.findByUserId(userId);
		return u.get();
	}

//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public Optional<User> findByUserIdAndPass(int userId, String pass) {
		Optional<User> u = ur.findByUserId(userId);
		boolean verified = false;
		if (u.isPresent()) {
		String id = "";
		id += u.get().getUserId();
		if (verifyUserPassword(pass, u.get().getPass(), id)) {
			return u;
		} else {
			u = Optional.empty();
		}
		};
		return u;
		
	}

//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public User findByUserIdAndEmail(int userId, String email) {
		return ur.findByUserIdAndEmail(userId, email);
	}
	
//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public User findByAssociateId(int associateId) {
		return ur.findByAssociateId(associateId);
	}

//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public List<User> findByRole(int role) {
		return ur.findByRole(role);
	}
	
//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public User createUser(User u) {
		String id = "";
		id += u.getUserId();
		u.setPass(generateSecurePassword(u.getPass(), id));
		return ur.save(u);
	}

//	@HystrixCommand(fallbackMethod = "sendStatusCode")
	public void saveAndFlush(User user) {
		String id = "";
		id += user.getUserId();
		user.setPass(generateSecurePassword(user.getPass(), id));
		ur.saveAndFlush(user);
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<String> sendStatusCode(){
		return new ResponseEntity<String>("Service is currently unavailable", HttpStatus.SERVICE_UNAVAILABLE);
	}

}
