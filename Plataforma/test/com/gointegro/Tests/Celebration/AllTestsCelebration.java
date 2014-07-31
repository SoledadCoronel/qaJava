package com.gointegro.Tests.Celebration;

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
	testNewCategory.class,
	testEditCategory.class,
	testDeleteCategory.class,
	testNewCelebration.class,
	testEditCelebration.class,
	testDeleteCelebration.class,
	testViewEventsSince.class, //Fallan un par de tests por https://gointegro.atlassian.net/browse/PLATAFORMAII-3050*/
	testCategoryAutomatic.class,
	testOrderCategory.class
})
public class AllTestsCelebration {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver(firefox,null));
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsCelebration.driver = driver;
	}
	
	@AfterClass
	 public static void tearDown() {
		driver.quit();
	}

}
