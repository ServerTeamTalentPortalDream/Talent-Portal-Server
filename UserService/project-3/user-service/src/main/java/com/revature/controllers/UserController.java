package com.revature.controllers;

import java.util.ArrayList;
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
import com.revature.dto.ResetPass;
import com.revature.dto.ResourcesCred;
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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@JsonIgnoreProperties
@RequestMapping("users")
public class UserController {

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

	// PUT

	@PutMapping("resetPassword")
	public String resetPassword(@RequestBody ResetPass rp) {
		User user = us.findByUserId(rp.getUserId());
		String id = "";
		id += rp.getUserId();
		if (user.getPass().equals(UserService.generateSecurePassword(rp.getCurrentPassword(), id))) {
			user.setPass(rp.getNewPassword());
			us.saveAndFlush(user);
			return "Password successfully changed";
		}
		return "Password did not match. Try Again";
	}

	@PutMapping("setPassword")
	public void temporaryPassword(@RequestBody Credentials u) {
		User user = us.findByUserId(u.getUserId());
		user.setPass(u.getPass());
		us.saveAndFlush(user);
	}

	@PutMapping("update/{associateId}")
	public void createUserResources(@RequestBody Resources r, @PathVariable int associateId) {
		User user = us.findByAssociateId(associateId);
		if (user.getAssociateId() == associateId) {
			Resources newResource = new Resources();
			newResource.setAssociateId(associateId);
			newResource.setAupCert(r.isAupCert());
			newResource.setProjectId(r.getProjectId());
			newResource.setCompetencyTag(r.getCompetencyTag());
			newResource.setGrade(r.getGrade());
			newResource.setJoinDate(r.getJoinDate());
			newResource.setLeaveDate(r.getLeaveDate());
			newResource.setSkillGroupId(r.getSkillGroupId());
			newResource.setCerts(new ArrayList<Certs>());
			newResource.setSkills(new ArrayList<Skills>());
			newResource.setResumes(new ArrayList<Resumes>());
			rs.saveAndFlush(newResource);
		}
		us.saveAndFlush(user);
	}

	@PutMapping("update/{associateId}/{resourceId}")
	public void updateUserResources(@RequestBody ResourcesCred rc, @PathVariable int associateId,
			@PathVariable int resourceId) {
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

	@GetMapping("skills/{associateId}")
	public List<UserSkills> findAllUserSkills(@PathVariable int associateId) {
		List<User> users = us.findAll();
		for (User user : users) {
			if (user.getAssociateId() == associateId) {
				return user.getUserSkills();
			}
		}
		return null;
	}

	@GetMapping("certs/{associateId}")
	public List<UserCerts> findAllUserCerts(@PathVariable int associateId) {
		List<User> users = us.findAll();
		for (User user : users) {
			if (user.getAssociateId() == associateId) {
				return user.getUserCerts();
			}
		}
		return null;
	}
}
