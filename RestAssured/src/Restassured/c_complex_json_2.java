 package Restassured;

import files.payload;
import io.restassured.path.json.JsonPath;

public class c_complex_json_2 {
public static void main(String[] args) {
	
	JsonPath js = new JsonPath(payload.CoursePrice());
	
	//Print all the courses and their prices
	
	int count = js.getInt("courses.size()");
	System.out.println(count);
	
	for(int i=0;i<count;i++) {
		System.out.print(js.getString("courses["+i+"].title"));
		System.out.print(" : "+js.getInt("courses["+i+"].price"));
		System.out.println();
	}
	
	//Print no of copies sold for RPA
	
	for(int i=0;i<count;i++) {
		String title = js.getString("courses["+i+"].title");
		if(title.equalsIgnoreCase("rpa")) {
			System.out.println(js.getInt("courses["+i+"].copies"));
			break;
		}
	}
}
}
