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

import com.revature.exception.InvalidJWTException;
import com.revature.models.Resources;
import com.revature.services.ResourcesService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@CrossOrigin
@RestController
@RequestMapping("resources")
public class ResourceController {
	@Autowired
	private ResourcesService rs;
	
	@GetMapping
	public List<Resources> findAll(@RequestHeader("JWT" ) String JWT) {
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
		return rs.findAll();
	}
	
	@GetMapping("{resourceId}")
	public Resources findByResourceId(@RequestHeader("JWT") String JWT, @PathVariable int resourceId) {
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
		Resources r = rs.findByResourceId(resourceId);
		return r;
	}

}
