package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.hamcrest.Matchers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Baseclass {

	RequestSpecification requestSpec;
	long maxTimeout = 4000;
	ResponseSpecification responseSpec;

	public RequestSpecification requestSpecification() throws IOException {
		if (requestSpec == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
			requestSpec = new RequestSpecBuilder().setBaseUri(getProperty(keywords.baseurl))
					.addHeader("Content-Type", "application/json").addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return requestSpec;
		}
		return requestSpec;
	}

	public ResponseSpecification responseSpecification() {
		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectResponseTime(Matchers.lessThan(maxTimeout)).build();
		return responseSpec;
	}

	public static String getProperty(String key) throws IOException {
		FileInputStream file = new FileInputStream("src/test/java/resources/config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}

	public String getJsonValue(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		String value = js.getString(key);
		System.out.println(value);
		return value;

	}
	
	/*public RequestSpecification GraphQLrequestspec() throws IOException {
		if(requestSpec == null) {
		PrintStream logg = new PrintStream(new File("logs.txt"));
		requestSpec = new RequestSpecBuilder().setBaseUri(getProperty("graphQLurl"))
				.addFilter(RequestLoggingFilter.logRequestTo(logg))
				.addFilter(ResponseLoggingFilter.logResponseTo(logg))
				.addHeader("Content-Type", "application/json").build(); 
		return requestSpec;
		}
		return requestSpec;
	}*/
}
