package POJO.classes;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class addplaceTest {
public static void main(String[] args) {
	addplace pj = new addplace();
	pj.setAccuracy(87);
	pj.setAddress("lavesh mane valase kar?");
	pj.setLanguage("marathi::hi::eng");
	pj.setName("lavesh");
	pj.setPhone_number("784598215484");
	pj.setWebsite("www.laveshmane.com");
	
	List<String> types = new ArrayList<>();
	types.add("typeA");
	types.add("typeB");
	
	pj.setTypes(types);
	
	addplaceLocation loc = new addplaceLocation();
	loc.setLatitude(-869846.454);
	loc.setLongitude(+556464.145);
	
	pj.setLocation(loc);
	
	RestAssured.baseURI = "https://rahulshettyacademy.com/";
	given().log().all().headers("Content-Type","application/json").queryParam("key", "qaclick123")
	.body(pj)
	.when().post("maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200);
}
}
