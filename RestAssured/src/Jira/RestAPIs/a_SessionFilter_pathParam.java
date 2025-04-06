package Jira.RestAPIs;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class a_SessionFilter_pathParam {
public static void main(String[] args) {
	SessionFilter session = new SessionFilter();
	
	RestAssured.baseURI = "http://localhost:8080/";
	given().log().all().header("Content-Type","application/json").body("{ \"username\": \"lavesh\", \"password\": \"1234\" }").
	when().filter(session).post("rest/auth/1/session").then()
	.log().all().assertThat().statusCode(200);
	
	given().log().all().header("Content-Type","application/json").pathParam("key", "10002")
	.body("{\r\n"
			+ "  \"body\": \"Assured comment\",\r\n"
			+ "  \"visibility\": {\r\n"
			+ "    \"type\": \"role\",\r\n"
			+ "    \"value\": \"Administrators\"\r\n"
			+ "  }\r\n"
			+ "}").filter(session).when().post("rest/api/2/issue/{key}/comment").then()
	.log().all().assertThat().statusCode(201);
	
}
}
