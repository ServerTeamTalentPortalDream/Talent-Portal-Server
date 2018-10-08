package com.revature.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Skills;
import com.revature.services.SkillsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@CrossOrigin
@RestController
@RequestMapping("skills")
public class SkillsController {

	@Autowired
	private SkillsService ss;
	
	@GetMapping
	public List<Skills> findAll(@RequestHeader("JWT" )String JWT){
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
		Assert.assertEquals(scope, "self groups/users");
//		Assert.assertEquals(scope, "self groups/admins");
		
		return ss.findAll();
	}
	
	@GetMapping("{id}")
	public Skills findById(@RequestHeader("JWT" )String JWT, @PathVariable int id) {
		
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
		Assert.assertEquals(scope, "self groups/users");
		
		return ss.findById(id);
	}
}
