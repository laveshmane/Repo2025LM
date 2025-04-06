package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class baseclass {

	public static JsonPath RawtoJSON(String resp) {
		JsonPath js = new JsonPath(resp);
		return js;
	}
	
	public static String getProperty(String propertyname) throws IOException {
		String path = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(path+"/src/files/config.properties");
		Properties prop = new Properties();
	    prop.load(file);
		String value = prop.getProperty(propertyname);
		return value;
	}
	
	public String getjsonfile () throws IOException{
//		String payload = null;
//		try {
		String path = System.getProperty("user.dir");
		return new String(Files.readAllBytes(Paths.get(path+"/src/files/payload.json")));
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//		return payload;
		
	}
}
