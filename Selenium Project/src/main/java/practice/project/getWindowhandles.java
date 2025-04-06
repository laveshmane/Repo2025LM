package practice.project;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class getWindowhandles {
public static void main(String[] args) {
	String path = System.getProperty("user.dir");
	System.out.println(path);
	System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("guru99 selenium tutorial");
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).build().perform();
	
	WebElement link = driver.findElement(By.xpath("//h3"));
	act.contextClick(link).keyDown(Keys.CONTROL).click(link).build().perform();
	
	Set<String> set = driver.getWindowHandles();
	ArrayList<String> list = new ArrayList<String>(set);
	String targer = list.get(1);
	driver.switchTo().window(targer);
}
}
