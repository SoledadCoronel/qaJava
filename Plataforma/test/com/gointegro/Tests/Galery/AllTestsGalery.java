package com.gointegro.Tests.Galery;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	testNewAlbum.class,
	testEditAlbumName.class,
	testDeleteAlbum.class,
	testUploadFile.class,
	testImageDetail.class,
	testDeleteImage.class,
	testSetAsCover.class
})
public class AllTestsGalery {
	
private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		setDriver(new FirefoxDriver());
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsGalery.driver = driver;
	}
	
	
	@AfterClass
	public static void tearDown() {
		//driver.quit();
	}

}
