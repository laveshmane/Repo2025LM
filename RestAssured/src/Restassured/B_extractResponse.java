package Restassured;

import files.payload;

import files.variables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
 
import static io.restassured.RestAssured.*;
public class B_extractResponse {
public static void main(String[] args) {
	
	RestAssured.baseURI = variables.baseURI;
	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(payload.Addplace())
	.when().post(variables.postresource)
	.then().extract().response().asString();
	
	System.out.println("-------------------------");
	
	JsonPath path = new JsonPath(response);
	String placeid = path.get("place_id");
	
	System.out.println(placeid);
}
}
