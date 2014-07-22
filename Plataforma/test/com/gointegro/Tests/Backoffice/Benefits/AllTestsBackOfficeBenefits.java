package com.gointegro.Tests.Backoffice.Benefits;

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
	testNewCompany.class,
	testNewCategory.class,
	testNewSubCategory.class,
	testNewSpecial.class,
	testNewContact.class,
	testNewBenefit.class,
	testNewFile.class,
	testNewVisibleFile.class,
	testNewStore.class,
	//testNewTerminal.class,
	testEditCompany.class,
	testEditCategory.class,
	testEditBenefit.class,
	testEditSpecial.class,
})

public class AllTestsBackOfficeBenefits {

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
		AllTestsBackOfficeBenefits.driver = driver;
	}
	
	@AfterClass
	 public static void tearDown() {
		driver.quit();
	}
}
