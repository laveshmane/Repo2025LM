package OAuth_2.O;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class autherization_code {
public static void main(String[] args) {
	

	//String url after login manually
	String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AWgavdfwq7BYWJtobdB3wWIRVp-fYA2rZUqiD_1HowTyPbpNFbmMNEPnhk2QixCilyQ-hQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=consent";
	String partialUrl=url.split("code=")[1];
	String code = partialUrl.split("&scope")[0];
	
	System.out.println(code);
	
	String tokenresponse = given().log().all().urlEncodingEnabled(false).queryParam("code", code)
	.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
	.queryParam("grant_type", "authorization_code")
	.when().log().all()
	.post("https://www.googleapis.com/oauth2/v4/token").asString();
	
	JsonPath js = new JsonPath(tokenresponse);
	String accessToken = js.getString("access_token");
	
	System.out.println(accessToken);
	
	given().log().all().queryParam("access_token", accessToken)
	.when().log().all()
	.get("https://rahulshettyacademy.com/getCourse.php")
	.then().assertThat().statusCode(200).extract().response().asString();
}	
}
