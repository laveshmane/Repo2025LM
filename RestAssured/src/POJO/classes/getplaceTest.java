package POJO.classes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class getplaceTest {

	@Test
	public void getplace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=cadb8d0f10daf8e92f2e6b6a386f4c42";
		given().log().all().accept("application/json")
		.when().get()
		.then().log().all().assertThat().statusCode(200).extract().response().as(addplace.class);
		
//		JsonPath js = new JsonPath(resp);
//		System.out.println(js);
//		System.out.println(resp);
	}
}
