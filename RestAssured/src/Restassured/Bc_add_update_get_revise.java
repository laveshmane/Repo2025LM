package Restassured;

import files.payload;
import files.variables;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class Bc_add_update_get_revise {
public static void main(String[]args) {
	
	RestAssured.baseURI = variables.baseURI;
	
	//Post
	String response = given().log().all().queryParam("key", "qaclick123").body(payload.Addplace())
	.when().post(variables.postresource)
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
			
	JsonPath js = new JsonPath(response);
	String placeid = js.get("place_id");
	
	System.out.println(placeid);
	String newaddress = "New address updated 9384";
	//Update
	given().log().all().queryParam("key", "qaclick123").contentType("application/json")
	.body(payload.UpdateAddress(placeid, newaddress))
	.when().put(variables.putresource)
	.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
	
	//get
	String getresp = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	.when().get(variables.getresource)
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath jsget = 
			new JsonPath(getresp);
	String updatedaddress = jsget.get("address");
	
	Assert.assertEquals(newaddress, updatedaddress);
	
	//delete
	given().log().all().queryParam("key", "qaclick123")
	.body(payload.DeleteBody(placeid))
	.when().delete(variables.deleteresource)
	.then().assertThat().statusCode(200);
	
	//get again
	given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	.when().get(variables.getresource)
	.then().log().all().assertThat().statusCode(404);
	System.out.println("-------------Success-------------");
}
}
