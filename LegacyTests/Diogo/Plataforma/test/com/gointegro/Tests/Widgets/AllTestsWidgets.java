package com.gointegro.Tests.Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gointegro.Tests.Base.TestBase;

public class AllTestsWidgets extends TestBase {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver(firefox,null));
		
		driver.manage().window().maximize();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsWidgets.driver = driver;
	}
	
	@AfterClass
	public static void tearDownClass() {
		driver.quit();
	}
}
