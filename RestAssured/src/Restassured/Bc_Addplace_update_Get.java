package Restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.payload;
import files.variables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Bc_Addplace_update_Get {

	public static void main(String[] args) {
		
		RestAssured.baseURI = variables.baseURI;
		
		//Post
		String response = given().queryParam("key", "qaclick123").header("Content-Type","application/json").body(payload.Addplace())
		.when().post(variables.postresource)
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath path = new JsonPath(response);
		String placeid = path.getString("place_id");
		System.out.println(placeid);
		
		String newaddress = "Lavesh Mane valase";
		//put
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"place_id\": \""+placeid+"\",\r\n"
				+ "  \"address\": \""+newaddress+"\",\r\n"
				+ "  \"key\": \"qaclick123\"\r\n"
				+ "}")
		.when().put(variables.putresource)
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get
		String getresponse = 
				given().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get(variables.getresource)
		.then().assertThat().statusCode(200).body("address", equalTo("Lavesh Mane valase")).extract().response().asString();
		
		JsonPath getresponsepath = new JsonPath(getresponse);
		String actualaddress = getresponsepath.getString("address");
		
		Assert.assertEquals(actualaddress, newaddress);
		
	}
	
}
