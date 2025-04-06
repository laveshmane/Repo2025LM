package Restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.baseclass;

public class D_addbook_DynamicPayload {

	@Test
	public void addbook() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/Library/Addbook.php";
		String resp = given().log().all().accept("application/json").
				body(payload.AddbookPayload("love", "784")).
		when().post().
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = baseclass.RawtoJSON(resp);
		String id = js.get("ID");
		
		
		Assert.assertEquals(id, "love784");
	}
}
