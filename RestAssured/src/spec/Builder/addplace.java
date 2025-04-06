package spec.Builder;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class addplace {
@Test
public void testass() {
	//Request spec builder
	RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setAccept(ContentType.JSON).addQueryParam("key", "qaclick123").build();
	
	//Response spec bulder
		long maxTimeout = 4000;
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).expectResponseTime(Matchers.lessThan(maxTimeout)).build();
		
	RequestSpecification request = given().spec(requestSpec).body(payload.Addplace());
	
	request.when().post("maps/api/place/add/json")
	.then().spec(responseSpec).extract().response().asString();
	
	
}
}
