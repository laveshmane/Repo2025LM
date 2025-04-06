package Restassured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.baseclass;

public class D_GetstaticJsonpayload_File extends baseclass{
	@Test(enabled = false)
public void main () throws IOException {
	RestAssured.baseURI = "https://rahulshettyacademy.com/Library/Addbook.php";
	given().log().all().accept("application/json").body(getjsonfile()).
	when().post().
	then().assertThat().statusCode(200).body("Msg",equalTo("successfully added"));
}
	@Test
	public void del() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String resp = given().log().all().accept("application/json").
		body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/files/delete.json")))).
		when().delete("Library/DeleteBook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath objJs = baseclass.RawtoJSON(resp);
		Assert.assertEquals("book is successfully deleted",objJs.get("msg"));
	}
	
}
