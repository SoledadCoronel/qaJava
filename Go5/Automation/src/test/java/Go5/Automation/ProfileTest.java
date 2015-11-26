package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ProfileTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
	   openSiteLogin();
	   login("marina.touceda@gointegro.com","Auto1234");
	   
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=1)
	public void EnterTheHomePage(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Login into GoIntegro and check the menu is present");
		driver.findElement(By.cssSelector(".user")).isDisplayed();
		
	}
	
	
	@Test(priority=2)
	public void validateElementsAtHomePage() throws Exception { 
	
 	  	log.info("Validate elements present in the page");
 	  	driver.findElement(By.cssSelector(".menu")).isDisplayed();
 	  	log.info("Menu is present");
	}

	
}
