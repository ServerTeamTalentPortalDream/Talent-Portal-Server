package com.revature.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.InvalidJWTException;
import com.revature.model.SkillGroup;
import com.revature.services.SkillGroupService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@CrossOrigin
@RestController
@RequestMapping("skill-group")
public class SkillGroupContoller {

	private Logger log = Logger.getRootLogger();
	@Autowired
	private SkillGroupService sgs;
	
	@GetMapping
	public List<SkillGroup> findAll(@RequestHeader("JWT" )String JWT) {
		
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
			log.warn(e);
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		}
		String scope = (String) claims.getBody().get("scope");

		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		
		log.info("Finding all Skill-Groups");
		
		return sgs.findAll();
	}
	
	@GetMapping("{id}")
	public SkillGroup findById(@RequestHeader("JWT" )String JWT, @PathVariable int id) {
		
		
		log.info("The id passed in is: " + id);
		
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
			log.warn(e);
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		}
		String scope = (String) claims.getBody().get("scope");

		if (!scope.equals("self groups/users")) {
			System.out.println("exception thrown for self not equal to scope");
			throw new InvalidJWTException();
		}
		
		log.info("Finding Skill-Group with id: " + id);
		
		return sgs.findById(id);
	}
}
