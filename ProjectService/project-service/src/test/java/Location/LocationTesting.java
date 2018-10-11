package Location;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.response.Response;


public class LocationTesting {
	
	@Test
	public void testCertifications() {
		Response response = given()
				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8088/location");
		assertEquals(response.getStatusCode(),201);
		System.out.println(response.asString());
	}

}
