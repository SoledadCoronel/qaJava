package com.gointegro.Tests.Widgets;

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
	/*testDeleteAllWidgets.class,
	testNewTextWidget.class,
	testNewImageWidget.class,
	testNewInstalledAppWidget.class,
	testEditTextWidget.class,
	testEditImageWidget.class,
	testOrderSizeWidgets.class,
	testEditInstalledAppWidget.class,
	testDeleteTextWidget.class,
	testDeleteImageWidget.class,*/
	testDeleteInstalledAppWidget.class,
})

public class AllTestsWidgets {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
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
	public static void tearDown() {
		driver.quit();
	}
}
