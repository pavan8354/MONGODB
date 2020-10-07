package com.qa.mongodb.livereport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(mongodbtestlistener.class)
public class AmazonAppTest {
	WebDriver driver;
	
	@BeforeMethod
	
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\JAVALEARN\\filewriting\\chromedriver.exe");	
	ChromeOptions cop = new ChromeOptions();
	cop.addArguments("--headless");
	driver = new ChromeDriver(cop);
//	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.get("https://www.amazon.com");

	}
	
	@Test
	public void amazon_test1() {
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

	}
	
	@Test
	public void amazon_career() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Careers")).isDisplayed());

	}
	
	@Test
	public void amazon_BC() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Amazon Business Card")).isDisplayed());

	}
	
	@Test
	public void amazon_points() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Shop with Points")).isDisplayed());

	}
	
	@Test
	public void amazon_tours() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Amazon Tours")).isDisplayed());

	}
	
	@Test
	
	public void Laptop_display() {
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("computer");
		driver.findElement(By.xpath("//input[@value='Go']")).click();	
		String text = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
		Assert.assertEquals(text, "computer");
	}
	
	@AfterMethod
	
	public void teardown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
