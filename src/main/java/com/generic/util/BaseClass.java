package com.generic.util;

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

	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();

	public WebDriver d = null;
	public static WebDriver SDriver;

	@BeforeSuite
	public void BSConfig() {
		System.out.println("Connect to database");
	}

	@BeforeClass
	public void BCConfig() {
		// Launch the browser
		String BROWSER = "";

		if (BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			System.out.println(BROWSER + " Browser launched");
		} else if (BROWSER.equals("fire")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
			System.out.println(BROWSER + " Browser launched");
		}

		SDriver = d;

		// Maximise the Screen

		// WebDriver Wait to page load.

		// get() URL
	}

	@BeforeMethod
	public void BMConfig() {
		// Login to Application
		String app = "";
		System.out.println(app + " application launched.");
	}

	@AfterMethod
	public void AMConfig() {
		// Logout to Application
		String app = "";
		System.out.println(app + " application closed.");
	}

	@AfterClass
	public void ACConfig() {
		// Quit the browser
		String BROWSER = "";
		System.out.println(BROWSER + " Browser closed");
		d.quit();
	}

	@AfterSuite
	public void ASConfig() {
		System.out.println("Close Connection to database");
	}

}
