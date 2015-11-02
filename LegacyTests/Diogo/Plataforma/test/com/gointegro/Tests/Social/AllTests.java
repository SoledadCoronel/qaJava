package com.gointegro.Tests.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gointegro.Tests.Base.TestBase;

public class AllTests extends TestBase {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, 
		   org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);
		
		FirefoxBinary firefox = new FirefoxBinary();
		
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver (firefox,null, cap));
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTests.driver = driver;
	}
	
	@AfterClass
	 public static void tearDownClass() {
		driver.quit();
	}

}
