package Restassured;

import files.payload;
import files.variables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.baseclass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class BC_add_update_get_assert extends  baseclass{

	public static void main(String[] args) {
		
		RestAssured.baseURI = variables.baseURI;
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.Addplace())
		.when().post(variables.postresource)
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsobject = RawtoJSON(response);
		String placeid = jsobject.get("place_id");
		
		
		System.out.println("-------------Post completed -------------");
		String newaddress = "Lavesh's new address Srilanka";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"place_id\": \""+placeid+"\",\r\n"
				+ "  \"address\": \""+newaddress+"\",\r\n"
				+ "  \"key\": \"qaclick123\"\r\n"
				+ "}")
		.when().put(variables.putresource)
		.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		System.out.println("-------------Put completed -------------");
		
		String getresponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get(variables.getresource)
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath getresponject = RawtoJSON(getresponse);
		String actualaddress = getresponject.get("address");
		
		System.out.println("-------------Get completed -------------");
				
		
		Assert.assertEquals(newaddress, actualaddress,"Address Mismatch occured.......!!!!!");
	}
}
