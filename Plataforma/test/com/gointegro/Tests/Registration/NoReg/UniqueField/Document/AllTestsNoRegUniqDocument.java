package com.gointegro.Tests.Registration.NoReg.UniqueField.Document;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AllTestsNoRegUniqDocument {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver(firefox,null));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsNoRegUniqDocument.driver = driver;
	}
	
	
	@AfterClass
	public static void tearDownClass() {
		driver.quit();
	}

}
