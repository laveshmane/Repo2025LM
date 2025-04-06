package Jira.RestAPIs;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import utilities.baseclass;

public class b_addFile {
@Test
public void addfile() throws IOException {
	RestAssured.baseURI = baseclass.getProperty("baseurl");
	SessionFilter session = new SessionFilter();
	
	given().header("Content-Type","application/json").filter(session).log().all()
	.body("{ \"username\": \"lavesh\", \"password\": \"1234\" }").when()
	.post("rest/auth/1/session").then()
	.assertThat().statusCode(200);
	
	File img = new File("src/files/bug.jpg.png");
	given().header("X-Atlassian-Token","no-check").filter(session).log().all().
	pathParam("issueid", "10002").
	header("Content-Type","multipart/form-data").
	multiPart("file",img).
	when()
	.post("rest/api/2/issue/{issueid}/attachments").
	then().log().all().assertThat().statusCode(200);
}
}
