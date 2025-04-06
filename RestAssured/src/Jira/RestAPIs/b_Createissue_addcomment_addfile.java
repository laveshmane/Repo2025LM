package Jira.RestAPIs;

import java.io.File;
import java.io.IOException;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import utilities.baseclass;

public class b_Createissue_addcomment_addfile {
public static void main(String[] args) throws IOException {
	
	RestAssured.baseURI = baseclass.getProperty("baseurl");
	SessionFilter session = new SessionFilter();
	
	//Create session
	given().header("Content-Type","application/json").filter(session).body("{ \"username\": \"lavesh\", \"password\": \"1234\" }")
	.when().post("rest/auth/1/session")
	.then().assertThat().statusCode(200);
	
	//Create issue
	String issueresp = given().header("Content-Type","application/json").filter(session).
	body("{\r\n"
			+ "    \r\n"
			+ "    \"fields\": {\r\n"
			+ "        \"project\": {\r\n"
			+ "            \"key\": \"RES\"\r\n"
			+ "        },\r\n"
			+ "        \"summary\": \"Issue new created\",\r\n"
			+ "        \"description\": \"Created using java=Restassured Library\",\r\n"
			+ "        \"issuetype\": {\r\n"
			+ "            \"name\": \"Bug\"\r\n"
			+ "        }        \r\n"
			+ "    }\r\n"
			+ "}")
	.when().post("rest/api/2/issue")
	.then().assertThat().statusCode(201).extract().response().asString();
	JsonPath issueJs = baseclass.RawtoJSON(issueresp);
	
	//Add comment
	given().header("Content-Type","application/json").filter(session).pathParam("issueId", issueJs.getString("id"))
	.body("{\r\n"
			+ "  \"body\": \"tujya aichi gand\",\r\n"
			+ "  \"visibility\": {\r\n"
			+ "    \"type\": \"role\",\r\n"
			+ "    \"value\": \"Administrators\"\r\n"
			+ "  }\r\n"
			+ "}")
	.when().post("rest/api/2/issue/{issueId}/comment")
	.then().assertThat().statusCode(201);
	
	//add File
	File file = new File("src/files/payload.json");
	
	given().header("X-Atlassian-Token","no-check").filter(session).pathParam("issueId", issueJs.getString("id"))
	.header("Content-Type","multipart/form-data")
	.multiPart("file",file).
	when().post("rest/api/2/issue/{issueId}/attachments")
	.then().assertThat().statusCode(200);
}
}
