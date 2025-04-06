package POJO.classes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class RestPojoClass1 {
@Test
public void test() {
	pojo1 deletepayLoad = new pojo1();
	deletepayLoad.setID("Loav82");
		
	RestAssured.baseURI = "https://rahulshettyacademy.com/";
	given().log().all().accept("application/json")
	.body(deletepayLoad)
	.when().delete("Library/DeleteBook.php")
	.then().assertThat().statusCode(200);
}
}
