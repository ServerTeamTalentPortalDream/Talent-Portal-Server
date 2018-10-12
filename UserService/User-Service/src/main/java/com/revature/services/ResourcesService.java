package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Certs;
import com.revature.models.Resources;
import com.revature.models.Resumes;
import com.revature.models.Skills;
import com.revature.models.UserCerts;
import com.revature.models.UserSkills;
import com.revature.repos.CertsRepo;
import com.revature.repos.ResourcesRepo;
import com.revature.repos.ResumeRepo;
import com.revature.repos.SkillsRepo;
import com.revature.repos.UserCertsRepo;
import com.revature.repos.UserSkillsRepo;

@Service
public class ResourcesService {
	@Autowired
	private ResourcesRepo rr;
	@Autowired
	private SkillsRepo sr;
	@Autowired
	private CertsRepo cr;
	@Autowired
	private UserSkillsRepo usr;
	@Autowired
	private UserCertsRepo ucr;
	@Autowired
	private ResumeRepo ures;
	
	public Resources save(Resources r) {
		return rr.save(r);
	}
	public Resources saveAndFlush(Resources r) {
		
		Resources r1=rr.saveAndFlush(r);
		ArrayList<Skills> uskil1=new ArrayList<Skills>();
		

		for(Skills each:r.getSkills()) {
			Skills skill1=new Skills();
			skill1.setSkillId(each.getSkillId());
			skill1.setResourceId(r1.getResourceId());
			uskil1.add(skill1);
			System.out.println(each.getSkillId());
		}
		System.out.println(uskil1);
		sr.save(uskil1);
		ArrayList<Certs> certi=new ArrayList<Certs>();

		for(Certs each:r.getCerts()) {
			Certs certif=new Certs();
			certif.setCertId(each.getCertId());
			certif.setResourceId(r1.getResourceId());
			certi.add(certif);
		}
		cr.save(certi);
		ArrayList<UserSkills> uskil=new ArrayList<UserSkills>();


		for(Skills each:r.getSkills()) {
			UserSkills skill=new UserSkills();
			skill.setSkillId(each.getSkillId());
			skill.setAssociateId(r.getAssociateId());
			uskil.add(skill);
		}
		usr.save(uskil);
		ArrayList<UserCerts> ucert=new ArrayList<UserCerts>();
	

		for(Certs each:r.getCerts()) {
			UserCerts cert=new UserCerts();
			cert.setCertId(each.getCertId());
			cert.setAssociateId(r.getAssociateId());
			ucert.add(cert);
		}
		ucr.save(ucert);
//		ArrayList<Resumes> res=new ArrayList<Resumes>();
//
//
//		for(Resumes each:r.getResumes()) {
//			Resumes ress=new Resumes();
//			ress.setId(each.getId());
//			ress.setResourceId(r.getResourceId());
//			ress.setResume(ures.findOne(each.getId()).getResume());
//			res.add(ress);
//		}
//	ures.saveAndFlush(res);
		return r1;
	}
	
	public Resources findByResourceId(int resourceId) {
		Resources r = rr.findByResourceId(resourceId);
		return r;
	}
	public List<Resources> findAll() {
		return rr.findAll();
	}

}
