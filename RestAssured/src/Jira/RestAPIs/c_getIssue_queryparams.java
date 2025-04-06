package Jira.RestAPIs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import utilities.baseclass;

public class c_getIssue_queryparams {
@Test
public void getIssue() throws IOException {
	RestAssured.baseURI = baseclass.getProperty("baseurl");
	SessionFilter filter = new SessionFilter();
	
	given().log().all().header("Content-Type","application/json").filter(filter)
	.body("{ \"username\": \"lavesh\", \"password\": \"1234\" }")
	.when().post("rest/auth/1/session")
	.then().assertThat().statusCode(200);
	
	//without Qurery parm
	given().log().all().header("Content-Type","application/json").filter(filter).pathParam("issueId", "10002")
	.when().get("rest/api/2/issue/{issueId}")
	.then().assertThat().statusCode(200).log().all();
	
	//With querry Param
	given().log().all().header("Content-Type","application/json").filter(filter).
	pathParam("issueId", "10002")
	.queryParam("fields", "issuetype,priority")
	.when().get("rest/api/2/issue/{issueId}")
	.then().assertThat().statusCode(200).log().all();
	
	//Get with List
	ArrayList<String> params = new ArrayList<>();
	params.add("issuetype");
	params.add("priority");
	params.add("watches");
	params.add("assignee");
	given().log().all().header("Content-Type","application/json").filter(filter).
	pathParam("issueId", "10002")
	.queryParam("fields", params)
	.when().get("rest/api/2/issue/{issueId}")
	.then().assertThat().statusCode(200).log().all();
	
}
}
