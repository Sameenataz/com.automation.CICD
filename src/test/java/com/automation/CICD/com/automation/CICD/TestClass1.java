package com.automation.CICD.com.automation.CICD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 {

	public static WebDriver driver;
	@BeforeMethod
	public void launchdriver() {
		System.out.println("Launching Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		System.out.println("Launching Browser ----");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
	}
	@Test
	public void test1() {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	@Test
	public void test2() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Java Selenium");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
	}
	@AfterMethod
	public void close() {
		driver.quit();
		
	}
	
}
