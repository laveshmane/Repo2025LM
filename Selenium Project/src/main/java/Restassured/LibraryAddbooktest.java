package Restassured;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import practice.project.Baseclass;

public class LibraryAddbooktest {
	@Test
	public void add() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Baseclass ba = new Baseclass();
		ArrayList<String> data = ba.getExcelData("RestAssuredData", "deleteplace");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));

		RequestSpecification reqspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.addHeader("Content-Type", "application/json").build();
		Response req = given().log().all().spec(reqspec).body(map).when().post("Library/Addbook.php");
		req.then().log().all().assertThat().statusCode(200);
	}
}
