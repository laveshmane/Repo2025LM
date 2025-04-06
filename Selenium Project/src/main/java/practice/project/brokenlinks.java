package practice.project;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class brokenlinks {
@SuppressWarnings("deprecation")
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
	WebDriver driver  =  new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://www.simplilearn.com/");
	List<WebElement> links = driver.findElements(By.xpath("//a"));
	
	for(WebElement link:links) {
		System.out.println(link.getText());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a"))));
		
	}
}
}
