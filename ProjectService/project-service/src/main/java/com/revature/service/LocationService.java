package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Location;
import com.revature.repos.LocationRepository;

@Service
public class LocationService {

		@Autowired
		private LocationRepository lr;
		
		public List<Location> findAll(){
			return lr.findAll();
		}
}
