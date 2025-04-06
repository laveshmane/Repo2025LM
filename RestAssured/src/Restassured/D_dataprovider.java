package Restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import files.testData;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class D_dataprovider {

	@Test(dataProvider = "booksSet1")
	public void addkitab(String isbn, String alise) {
		RestAssured.baseURI = "https://rahulshettyacademy.com/Library/Addbook.php";
		given().log().all().accept("application/json").body(payload.AddbookPayload(isbn,alise)).
		when().post().
		then().log().all().assertThat().statusCode(200).body("Msg",equalTo("successfully added"));
	}
	
	@DataProvider (name = "booksSet1")
	public Object[][] data() {
		Object[][] set1 = testData.booksSet1();
		return set1;		
		//return new Object[][] {{"seleniumaaa","34"},{"java","32423423"}};
	}
}
