package Ecommerce.API;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import POJO.classes.EcomAuthResponse;
import POJO.classes.EcomAuthpayload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class practice1 {
@Test
public void test1() {
	//Auth
	RequestSpecification authBase =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addHeader("Content-Type","application/json").build();
	
	EcomAuthpayload payload = new EcomAuthpayload();
	payload.setUserEmail("lavesh@restassured.com");
	payload.setUserPassword("Master0fL1fe");
	
	RequestSpecification authReq = given().log().all().spec(authBase).body(payload);
	EcomAuthResponse authResp = authReq.when().post("api/ecom/auth/login").then().log().all().assertThat().statusCode(200).extract().response().as(EcomAuthResponse.class);
	
	System.out.println(authResp.getToken());
	System.out.println(authResp.getMessage());
	String token = authResp.getToken();
	String userid = authResp.getUserId();
	
	//Add product
	
//	RequestSpecification addProdBase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addHeader("Authorization", token).build();
//	
//	RequestSpecification addProdreq = addProdBase.given().log().all().spec(addProdBase)
//	.param("productName", "lappy").param("productAddedBy", userid)
//	.param("productCategory", "Electronics").param("productSubCategory", "computers")
//	.param("productPrice", "$500").param("productDescription", "Asus oled")
//	.param("productFor", "All")
//	.multiPart("productImage", new File("\"C:\\RestAssured\\R.png\""));
//	
//	addProdreq.when().post("/api/ecom/product/add-product").then().log().all();
	
	//Get product
	
	RequestSpecification getprodbase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom/").
			addHeader("Authorization", token).build();
	
	RequestSpecification getprodreq = given().log().all().spec(getprodbase).pathParam("productId", "6262e95ae26b7e1a10e89bf0");
	
	
	getprodreq.when().get("product/get-product-detail/{productId}").
	then().log().all().extract().response().asString();
	
	//Add to cart
	
}
}
