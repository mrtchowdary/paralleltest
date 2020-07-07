package com.parallel.practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters("brow")
	public void setUpMethod(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().arch32().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().arch32().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
	}

	@Test
	public void testCase(){
		System.out.println("Screen title is "+ driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
