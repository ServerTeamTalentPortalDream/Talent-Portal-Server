package com.revature.exception;
 import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 @ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class InvalidJWTException extends RuntimeException{
	// testing exception
} 