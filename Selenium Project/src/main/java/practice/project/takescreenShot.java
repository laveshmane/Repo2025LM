package practice.project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class takescreenShot {
public static void main(String[] args) throws InterruptedException, IOException {
	String path = System.getProperty("user.dir");
	System.out.println(path);
	System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https:/www.google.com");
	Thread.sleep(2000);
	File img = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File(path+"/src/main/resources/screenshots/google.jpg");
	FileHandler.copy(img, dest);
	
}
}
