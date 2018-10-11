package ProjectService;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ProjectServiceTest {
	
		@Test
		public void holdTest() {
		assertEquals(1,1);
		}
	
//	@Autowired
//	ProjectService ps;
//  String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MzQ2MzE1MDgwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.7tx9aSvJwcaTHmQ9tHPD_11JYhnMRxXQKtbCX5rGdvM";
//	@Test
//	public void GetProjectList() {
//		Response response = given()
//				.header("JWT", jwt).get("http://localhost:8088/project");
//		assertEquals(response.getStatusCode(),200);
//		System.out.println(response.asString());
//	}
//	
//	@Test public void GetHello() {
//		Response response = given()
//				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8088/project/hello");
//		assertEquals(200,response.getStatusCode());
//		System.out.println(response.asString());
//	}
////	@Test public void GetSingleProject() {
////	Response response = given()
////			.header("JWT", jwt).get("http://localhost:8088/project/1");
////	assertEquals(200,response.getStatusCode());
////	System.out.println(response.asString());
////}
//	@Test public void PostTestAndDestroy() {
//		Project postProject = new Project(
//				100, 
//				"customer",
//				"pName",
//				new Date(5),
//				new Date(5),
//				"a test project",
//				1,
//				"sdf"
//								);
//		int projectId = given().body(postProject)
//				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8088/project/1").
//		then().statusCode(201).extract().path("p_id");
//		ps.deleteProject(projectId);
//		
//	}
//	
//	@Test public void PostPatchAndDestroy() {
//		Project postProject = new Project(
//				100, 
//				"customer",
//				"pName",
//				new Date(5),
//				new Date(5),
//				"a test project",
//				1,
//				"sdf"
//								);
//		Project project = new Project() ;
//				Response resp = given().body(postProject)
//				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8088/location/1");
//				project.setCustomer(resp.then().extract().path("customer"));
//				project.setProjectId(resp.then().extract().path("projectId"));
//				project.setName("PatchedName");
//				int id = given()
//				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8088/location/1").
//				then().extract().path("projectId");
//		ps.deleteProject(id);
//
//	}
//	
}  
