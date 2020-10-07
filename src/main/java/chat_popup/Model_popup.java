package chat_popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Model_popup {
	 static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");	
		 driver = new ChromeDriver();
		
		driver.get("http://classic.crmpro.com/");
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("PAVAN");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-block-paragraph e19rsvrm0 intercom-1d3znxz']"))).build().perform();
		
		driver.findElement(By.xpath("//div[@class='intercom-lr0ri6 es6hgh14']//span")).click();
		
		
	}
	

}
