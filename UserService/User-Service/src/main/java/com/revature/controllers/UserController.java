 package com.revature.controllers;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.Credentials;
import com.revature.dto.ResetPass;
import com.revature.dto.ResourcesCred;
import com.revature.exception.InvalidJWTException;
import com.revature.models.Certs;
import com.revature.models.Resources;
import com.revature.models.Resumes;
import com.revature.models.Skills;
import com.revature.models.User;
import com.revature.models.UserCerts;
import com.revature.models.UserSkills;
import com.revature.services.CertsService;
import com.revature.services.EmailService;
import com.revature.services.ResourcesService;
import com.revature.services.SkillsService;
import com.revature.services.UserCertsService;
import com.revature.services.UserService;
import com.revature.services.UserSkillsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {
	SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	@Autowired
	private UserService us;
	@Autowired
	private EmailService es;
	@Autowired
	private UserSkillsService usk;
	@Autowired
	private UserCertsService uc;
	@Autowired
	private ResourcesService rs;
	@Autowired
	private SkillsService ss;
	@Autowired
	private CertsService cs;

	// POST

	@PostMapping
	public ResponseEntity<User> save(@RequestHeader("JWT") String JWT, @RequestBody User u) {
		ResponseEntity<User> re = new ResponseEntity<User>(u, HttpStatus.CREATED);
		us.createUser(u);
		return re;
	}

	@PostMapping("login")
	public ResponseEntity login(@RequestBody Credentials u) {
		Map<String, Object> data = new HashMap<String, Object>();
		String jwt = "0";
		Date expDate = Date.from(Instant.now().plusSeconds(86400));
		try {
			jwt = Jwts.builder().setSubject("users/TzMUocMF4p").setExpiration(expDate).claim("userid", u.getUserId())
					.claim("scope", "self groups/users")
					.signWith(SignatureAlgorithm.HS256, "goldfishtastemoney".getBytes("UTF-8")).compact();
		} catch (Exception e) {
			return new ResponseEntity<Map<String,Object>>(data,HttpStatus.UNAUTHORIZED);
		}
		Optional<User> user = us.findByUserIdAndPass(u.getUserId(), u.getPass());

		if (user.isPresent()) {
			data.put("user", user.get());
			data.put("jwt", jwt);
			return new ResponseEntity<Map<String,Object>>(data,HttpStatus.OK);
		} else {
			return new ResponseEntity<Map<String,Object>>(data,HttpStatus.UNAUTHORIZED);
		}

		
	}

	@PostMapping("changePass")
	public String findByUserIdAndEmail(@RequestBody Credentials u) {

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
		
		passwordResetEmail.setSubject("Talent Portal Reset Password Request");
		passwordResetEmail.setText("Here is your temporary password: " + String.copyValueOf(password));
		
		es.sendEmail(passwordResetEmail);
		user.setPass(String.copyValueOf(password));
		us.saveAndFlush(user);
		return String.copyValueOf(password);
	}

	// PUT

	@PutMapping("resetPassword")
	public User resetPassword(@RequestBody ResetPass rp) {
		User user = us.findByUserId(rp.getUserId());
		String id = "";
		id += rp.getUserId();
		if (user.getPass().equals(UserService.generateSecurePassword(rp.getCurrentPassword(), id))) {
			user.setPass(rp.getNewPassword());
			us.saveAndFlush(user);
			return user;
		}
		return null;
	}

	@PutMapping("setPassword")
	public void temporaryPassword(@RequestHeader("JWT") String JWT, @RequestBody Credentials u) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		User user = us.findByUserId(u.getUserId());
		user.setPass(u.getPass());
		us.saveAndFlush(user);
	}

	@PutMapping("update/{associateId}")

	public int createUserResources(@RequestHeader("JWT") String JWT, @RequestBody Resources r,
			@PathVariable int associateId) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		User user = us.findByAssociateId(associateId);
		if (user.getAssociateId() == associateId) {
			Resources newResource = new Resources();
			newResource.setAssociateId(associateId);
			newResource.setAupCert(r.isAupCert());
			newResource.setProjectId(r.getProjectId());
			newResource.setCompetencyTags(r.getCompetencyTags());
			newResource.setGrades(r.getGrades());
			newResource.setJoinDate(r.getJoinDate());
			newResource.setLeaveDate(r.getLeaveDate());
			newResource.setCerts(r.getCerts());
			newResource.setSkills(r.getSkills());
			newResource.setResumes(r.getResumes());
			return rs.saveAndFlush(newResource).getResourceId();
		}
		return 0;
	}

	@PutMapping("update/{associateId}/{resourceId}")
	public void updateUserResources(@RequestHeader("JWT") String JWT, @RequestBody ResourcesCred rc,
			@PathVariable int associateId, @PathVariable int resourceId) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		User user = us.findByAssociateId(associateId);
		for (Resources each : user.getResources()) {
			if (each.getResourceId() == resourceId) {

				Skills newSkills = new Skills();
				newSkills.setResourceId(resourceId);
				newSkills.setSkillId(rc.getSkillId());
				ss.saveAndFlush(newSkills);

				Certs newCerts = new Certs();
				newCerts.setResourceId(resourceId);
				newCerts.setCertId(rc.getCertId());
				cs.saveAndFlush(newCerts);

			}
			rs.saveAndFlush(each);
		}
		UserSkills newUserSkills = new UserSkills();
		newUserSkills.setAssociateId(associateId);
		newUserSkills.setSkillId(rc.getSkillId());
		usk.saveAndFlush(newUserSkills);

		UserCerts newUserCerts = new UserCerts();
		newUserCerts.setAssociateId(associateId);
		newUserCerts.setCertId(rc.getCertId());
		uc.saveAndFlush(newUserCerts);

		us.saveAndFlush(user);
	}

	// GET

	@GetMapping
	public List<User> findAll(@RequestHeader("JWT") String JWT) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		return us.findAll();
	}

	@GetMapping("{userId}")
	public User findByUserId(@RequestHeader("JWT") String JWT, @PathVariable int userId) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		User u = us.findByUserId(userId);
		return u;
	}

	@GetMapping("role/{role}")
	public List<User> findByRole(@RequestHeader("JWT") String JWT, @PathVariable int role) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		return us.findByRole(role);
	}
	
	@GetMapping("associate/{associateId}")
	public User findByAssociateId(@RequestHeader("JWT") String JWT, @PathVariable int associateId) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser()
			  .setSigningKey("goldfishtastemoney".getBytes("UTF-8"))
			  .parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		User u = us.findByAssociateId(associateId);
		return u;
	}

	@GetMapping("skills/{associateId}")
	public List<UserSkills> findAllUserSkills(@RequestHeader("JWT") String JWT, @PathVariable int associateId) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		List<User> users = us.findAll();
		for (User user : users) {
			if (user.getAssociateId() == associateId) {
				return user.getUserSkills();
			}
		}
		return null;
	}

	@GetMapping("certs/{associateId}")
	public List<UserCerts> findAllUserCerts(@RequestHeader("JWT") String JWT, @PathVariable int associateId) {
		String jwt = JWT;
		Jws<Claims> claims;
		claims = null;
		try {
			claims = Jwts.parser().setSigningKey("goldfishtastemoney".getBytes("UTF-8")).parseClaimsJws(jwt);
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String scope = (String) claims.getBody().get("scope");
		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		List<User> users = us.findAll();
		for (User user : users) {
			if (user.getAssociateId() == associateId) {
				return user.getUserCerts();
			}
		}
		return null;
	}
}
