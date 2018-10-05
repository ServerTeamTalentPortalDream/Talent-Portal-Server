package user.service;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
// import static org.hamcrest.Matchers;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostUserTesting {

		@Test
		public void postTest() {
			
			RestAssured.baseURI ="http://localhost:8080/users";
			
			// JSONObject is a class that represents a Simple JSON.
			// We can add Key - Value pairs using the put method
			JSONObject requestParams = new JSONObject();
			
			// you have to manually add new values for these or could use random method
			
			try {
				requestParams.put("firstName", "KyleTest5");
				requestParams.put("lastName", "MillerTest5");
				requestParams.put("email", "thisismyrealemail.com");
				requestParams.put("pass", "password7");
				requestParams.put("userId",  "228318");
				requestParams.put("role", "2");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// RequestSpecification request = (RequestSpecification) RestAssured.given().header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8080/users");
				
			RequestSpecification request = RestAssured.given();
			
			
			// Add a header stating the Request body is a JSON and include the JWT
			request.header("Content-Type", "application/json").and().header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY");
			 
			// Add the JSON to the body of the request
			request.body(requestParams.toString());
			 
			// Post the request and check the response
			Response response = request.post();			
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 201);
			
			// String successCode = response.jsonPath().get("SuccessCode");
			// System.out.println("this was our success code: " + successCode);
			// Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
			
		}
}
