package practice.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_class {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
	WebDriver driver  =  new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	WebElement BeaSeller = driver.findElement(By.xpath("(//a/span[contains(text(),'Become a Seller')])[1]"));
	Actions act = new Actions(driver);
	WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
	WebElement btn = driver.findElement(By.tagName("button"));
	//Thread.sleep(3000);
	act.click(btn).perform();
	//Thread.sleep(3000);
	act.clickAndHold(BeaSeller).perform();
	Thread.sleep(3000);
	act.moveToElement(search).perform();
	Thread.sleep(3000);
	act.release().perform();
	
	driver.get("http://demo.guru99.com/test/drag_drop.html");
	
	WebElement obj = driver.findElement(By.xpath("//a[text()='-5000 ']"));
	WebElement dest = driver.findElement(By.xpath("//a[text()='New Tours']"));
	Actions a = new Actions(driver);
	a.clickAndHold(obj).perform();
	Thread.sleep(3000);
	
	a.moveToElement(dest).perform();
	Thread.sleep(5000);
	
	a.release().perform();
	
}
}
