package com.gointegro.Tests.Profile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	testNewFile.class,
	testDeleteFile.class,
})

public class AllTestsProfile {

private static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		setDriver(new FirefoxDriver());
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsProfile.driver = driver;
	}
	
	@AfterClass
	 public static void tearDown() {
		driver.quit();
	}
}
