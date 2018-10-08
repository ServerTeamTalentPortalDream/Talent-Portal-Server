package com.revature.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Location;
import com.revature.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationController {

	Logger log = Logger.getRootLogger();
	@Autowired
	private LocationService ls;
	
	@GetMapping
	public List<Location> findLocations(){
		return ls.findAll();
	}
}
