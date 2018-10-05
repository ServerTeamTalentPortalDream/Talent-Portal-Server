package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo ur;

	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;

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

	public static String generateSecurePassword(String password, String salt) {
		String returnValue = null;
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		returnValue = Base64.getEncoder().encodeToString(securePassword);
		return returnValue;
	}

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

	public List<User> findAll() {
		return ur.findAll();
	}

	public User findByUserId(int userId) {
		User u = ur.findByUserId(userId);
		return u;
	}

	public User findByUserIdAndPass(int userId, String pass) {
		User u = ur.findByUserId(userId);
		String id = "";
		id += u.getUserId();
		if (verifyUserPassword(pass, u.getPass(), id)) {
			return u;
		}
		return null;
	}

	public User findByUserIdAndEmail(int userId, String email) {
		return ur.findByUserIdAndEmail(userId, email);
	}

	public List<User> findByRole(int role) {
		return ur.findByRole(role);
	}

	public User createUser(User u) {
		String id = "";
		id += u.getUserId();
		u.setPass(generateSecurePassword(u.getPass(), id));
		return ur.save(u);
	}

	public void saveAndFlush(User user) {
		String id = "";
		id += user.getUserId();
		user.setPass(generateSecurePassword(user.getPass(), id));
		ur.saveAndFlush(user);
	}

}
