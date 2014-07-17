package com.gointegro.Tests.News;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	testCreateNews.class,
	testEditNews.class,
	testDeleteNews.class,
	testFilterNews.class,
})

public class AllTestsNews {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver(firefox,null));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsNews.driver = driver;
	}
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
