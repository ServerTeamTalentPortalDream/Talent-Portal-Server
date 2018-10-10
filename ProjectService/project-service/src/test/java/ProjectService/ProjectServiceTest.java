package ProjectService;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Project;
import com.revature.service.ProjectService;

import io.restassured.response.Response;


public class ProjectServiceTest {
	@Autowired
	ProjectService ps;

	@Test
	public void GetProjectList() {
		Response response = given()
				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8088/project");
		assertEquals(response.getStatusCode(),200);
		System.out.println(response.asString());
	}
	
	@Test public void GetHello() {
		Response response = given()
				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8088/location/hello");
		assertEquals(response.getStatusCode(),200);
		System.out.println(response.asString());
	}
	@Test public void GetSingleProject() {
	Response response = given()
			.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").get("http://localhost:8088/location/1");
	assertEquals(response.getStatusCode(),200);
	System.out.println(response.asString());
}
	@Test public void PostTestAndDestroy() {
		Project postProject = new Project(
				100, 
				"customer",
				"pName",
				new Date(5),
				new Date(5),
				"a test project",
				1,
				"sdf"
								);
		int projectId = given().body(postProject)
				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8088/location/1").
		then().statusCode(201).extract().path("p_id");
		ps.deleteProject(projectId);
		
	}
	
	@Test public void PostPatchAndDestroy() {
		Project postProject = new Project(
				100, 
				"customer",
				"pName",
				new Date(5),
				new Date(5),
				"a test project",
				1,
				"sdf"
								);
		Project project = (Project) given().body(postProject)
				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8088/location/1").
				getBody();
			project.setName("PatchedName");
			Project patchedProject = (Project) given()
				.header("JWT", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2Vycy9Uek1Vb2NNRjRwIiwiZXhwIjo2MjUxNjM3OTYwMCwidXNlcmlkIjoxMjM0NTYsInNjb3BlIjoic2VsZiBncm91cHMvdXNlcnMifQ.nD9kCwmbAIpFj__Qq_e2_XOkbBCe6zhXu713DoBOCjY").post("http://localhost:8088/location/1").
				getBody();
		ps.deleteProject(patchedProject.getProjectId());

	}
	
}  