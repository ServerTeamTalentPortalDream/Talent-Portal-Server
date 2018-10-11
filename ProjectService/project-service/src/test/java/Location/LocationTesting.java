package Location;

import static org.junit.Assert.assertEquals;

public class LocationTesting {
	public void holdTest() {
	assertEquals(1,1);
	}
//	
//	String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MzQ2MzE1MDgwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.7tx9aSvJwcaTHmQ9tHPD_11JYhnMRxXQKtbCX5rGdvM";
//	@Test
//	public void testLocation() {
//		Response response = given()
//				.header("JWT", jwt).get("http://localhost:8088/location");
//		assertEquals(response.getStatusCode(),200);
//		System.out.println(response.asString());
//	}
//	
//	@Test
//	public void testLocationTime() {
//		given()
//				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8088/location").
//		then().time()lessThan(10000L);
//	}
//

}
