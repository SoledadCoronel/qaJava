package com.gointegro.Tests.Workspace;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	testDeleteAll.class,
	testEditWorkspace.class,
	testNewWorkspace.class,
	testDeleteWorkspace.class,
	testAddApplications.class,
	testEditApplications.class,
	testDeleteApplications.class,
})

public class AllTestsWorkspace {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		setDriver(new FirefoxDriver());
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsWorkspace.driver = driver;
	}
	
	@AfterClass
	 public static void tearDown() {
		driver.quit();
	}
}