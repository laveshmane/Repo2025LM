package Restassured;

import static org.testng.Assert.assertEquals;

import files.payload;
import io.restassured.path.json.JsonPath;

public class c_complex_json_3 {
public static void main(String[] args) {
	
	JsonPath js = new JsonPath(payload.Complexjson());
	
	int count = js.getInt("courses.size()");
	int P_Amount = js.getInt("dashboard.purchaseAmount");
	int sum = 0;
	
	for(int i=0; i<count; i++) {
		int pr = js.getInt("courses["+i+"].price");
		int cop = js.getInt("courses["+i+"].copies");
		int amount = pr*cop;
		sum = sum +amount;
	}
	
	assertEquals(P_Amount, sum,"Sum Mismatch");
	System.out.println(P_Amount);
	System.out.println(sum);
}
}
