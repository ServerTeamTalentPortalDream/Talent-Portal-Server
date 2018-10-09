package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Resources;
import com.revature.repos.ResourcesRepo;

@Service
public class ResourcesService {
	@Autowired
	private ResourcesRepo rr;
	
	public Resources save(Resources r) {
		return rr.save(r);
	}
	public Resources saveAndFlush(Resources r) {
		return rr.saveAndFlush(r);
	}
	
	public Resources findByResourceId(int resourceId) {
		Resources r = rr.findByResourceId(resourceId);
		return r;
	}
	public List<Resources> findAll() {
		return rr.findAll();
	}

}
