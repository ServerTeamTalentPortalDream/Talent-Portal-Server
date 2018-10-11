package user.service;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
// import static org.hamcrest.Matchers;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetUserTesting {
	
	@Test
	public void testUsers() {
		// given().header("MyHeader", "Something")
		
		Response response = given().header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8080/users");
		System.out.println(response.asString());
	}

}