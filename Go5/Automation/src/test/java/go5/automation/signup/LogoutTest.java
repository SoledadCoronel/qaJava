package go5.automation.signup;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class LogoutTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and login 
	 public void setup () throws Exception{
	   openSiteLogin();
	   login("marina.touceda@gointegro.com","Auto1234");
	   
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test
	public void logoutFromProfile(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Verify logout from user profile is working");
		// Go to the user menu
		driver.findElement(By.cssSelector(".applications .users .user")).click();
		// Made logout
		driver.findElement(By.cssSelector(".applications .active .users .active .logout")).click();
		log.info(" Logout has been successfull");
			
	}
	}

