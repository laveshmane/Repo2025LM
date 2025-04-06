package POJO.classes;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import utilities.baseclass;

public class getissuetest {
@Test
public void ere() throws IOException {
	RestAssured.baseURI = baseclass.getProperty("baseurl");
	SessionFilter filter = new SessionFilter();
	
	//Generate token
	given().log().all().header("Content-Type","application/json").filter(filter)
	.body("{ \"username\": \"lavesh\", \"password\": \"1234\" }")
	.when().post("rest/auth/1/session")
	.then().assertThat().statusCode(200);
	
	//Get issue
	getissue issueresp = given().log().all().header("Content-Type","application/json").filter(filter).
	pathParam("issueId", "10002")
	.queryParam("fields","priority")
	.when().get("rest/api/2/issue/{issueId}")
	.then().log().all().assertThat().statusCode(200).extract().response().as(getissue.class);
	
	System.out.println(issueresp.getKey());
}
}
