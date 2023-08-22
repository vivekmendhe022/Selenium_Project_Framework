package com.generic.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver d=null;
	
	@BeforeSuite
	public void BSConfig() {
		System.out.println("***** DB Connection Successful *****");
	}

	@BeforeClass
	public void BCConfig() {
		String BROWSER="";
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d=new ChromeDriver();			
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d=new FirefoxDriver();			
		}else {
			System.out.println("Invalid Browser Name: User 'chrome' or 'firefox'");
		}
		
		// Maximize the web application window
		d.manage().window().maximize();
		
		// Wait or web page load for web elements
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Load the Web URL
		d.get("");
		
	}

	@BeforeMethod
	public void BMConfig() {

	}

	@AfterMethod
	public void AMConfig() {

	}

	@AfterClass
	public void ACConfig() {

	}

	@AfterSuite
	public void ASConfig() {
		System.out.println("***** DB Closed Successful *****");

	}

}
