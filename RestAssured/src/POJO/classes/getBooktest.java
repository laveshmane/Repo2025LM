package POJO.classes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class getBooktest {

	@Test
	public void test() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		getbooklist getbookresp = given().accept("application/json").queryParam("ID", "bcd2926")
		.when().get("Library/GetBook.php").
		then().log().all()
		.assertThat().statusCode(200).extract().response().as(getbooklist.class);
		
		System.out.println(getbookresp.getGetbook().get(0).getBook_name());
	}
}
