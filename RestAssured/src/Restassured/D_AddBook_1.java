package Restassured;

import org.testng.annotations.Test;

import files.payload;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.baseclass;

public class D_AddBook_1 {

	@Test
	public void addbook() {
		RestAssured.baseURI  = "https://rahulshettyacademy.com/Library/Addbook.php";
		String Response = given().log().all().header("Content-Type","application/json").body(payload.AddbookPayload()).
		when().post().
		then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = baseclass.RawtoJSON(Response);
		String id = js.get("ID");
		System.out.println(id);
	}
}
