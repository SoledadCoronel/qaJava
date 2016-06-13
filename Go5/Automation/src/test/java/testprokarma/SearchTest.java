package testprokarma;


import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import go5.pageObjects.HomePageSirsi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SearchTest  {
	


HomePageSirsi home = null;
protected WebDriver driver;
protected String strSearch= "cosugi 2016";
protected String  strTitleToCompare="http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about";


@BeforeTest

public void setUp() throws Exception {
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cristina 1\\Documents\\Repo\\qa\\chromedriver");

	//WebDriver driver = new ChromeDriver();
	driver = new FirefoxDriver();
		FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("browser.usedOnWindows10", false);
	profile.setPreference("browser.usedOnWindows10.introURL", "about:blank");


	driver.get("http://www.sirsidynix.com");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
   }

@AfterTest // call function to close browser 
	
	public void teardown(){
		driver.close();
	}
		
	@Test
	
	public void searchTest() throws Exception { 
	
		
		home = new HomePageSirsi(driver);
		 
		// Run a search at the Home Page with the String cosugi 2016
	
	   home.searchForAString(strSearch);// Insert the string and run the search
	  home.waitForResults();// expected wait for results
	  Assert.assertEquals(strTitleToCompare, home.getSecondTitle());// Verify the title of the second node result
	
	   
	   
	}
}	
		
		