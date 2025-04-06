package Jira.RestAPIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import utilities.baseclass;

public class d_addComment_Assertcomment {
public static void main(String[] args) throws IOException {
	
	RestAssured.baseURI = baseclass.getProperty("baseurl");
	SessionFilter session = new SessionFilter();
	
	given().log().all().header("Content-Type","application/json").filter(session)
	.body("{ \"username\": \"lavesh\", \"password\": \"1234\" }")
	.when().post("rest/auth/1/session")
	.then().assertThat().statusCode(200);
	
	//Add comment
	String mycomment = "My comment How are u fucker?";
		String Commentresp = given().header("Content-Type","application/json").filter(session).
		pathParam("issueId", "10002")
		.body("{\r\n"
				+ "  \"body\": \""+mycomment+"\",\r\n"
				+ "  \"visibility\": {\r\n"
				+ "    \"type\": \"role\",\r\n"
				+ "    \"value\": \"Administrators\"\r\n"
				+ "  }\r\n"
				+ "}")
		.when().post("rest/api/2/issue/{issueId}/comment")
		.then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = new JsonPath(Commentresp);
		String ExpCommentid = js.get("id").toString();
		
		
		//Get comment 
		String actualcommentresp = given().log().all().header("Content-Type","application/json").filter(session).
		pathParam("issueId", "10002")
		.queryParam("fields", "comment")
		.when().get("rest/api/2/issue/{issueId}")
		.then().assertThat().statusCode(200).
		log().all().extract().response().asString();
		
		JsonPath js2 = new JsonPath(actualcommentresp);
		 int sizrArr= js2.get("fields.comment.comments.size()");
		 
		 for(int i=0; i<sizrArr; i++) {
			String actualcommentId = js2.get("fields.comment.comments["+i+"].id").toString();
			if(ExpCommentid.equalsIgnoreCase(actualcommentId)) {
				String actualmessage = js2.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(actualmessage);
				Assert.assertEquals(actualmessage, mycomment);
			}
		 }
		 
		 
		
		
}
}
