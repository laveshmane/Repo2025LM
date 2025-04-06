package Restassured;

import files.payload;
import io.restassured.path.json.JsonPath;

public class C_Complex_Json_1 {
public static void main(String[] args) {
	
	JsonPath js = new JsonPath(payload.CoursePrice());
	
	//Get size of courses
	int courseses = js.getInt("courses.size()");
	System.out.println(courseses);
	
	//Get purchase amount
	int puramount = js.getInt("dashboard.purchaseAmount");
	System.out.println(puramount);
	
	//Get name of third course
	String title3 = js.get("courses[3].title");
	System.out.println(title3);
}
}
