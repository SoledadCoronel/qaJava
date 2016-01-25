package go5.automation.home;


import go5.automation.CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class GroupsTest extends CommonFunctions{


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
		public void GoToGroups(){
			 
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			log.info("Ir a Grupos menu");
			
			// Go to the  Groups configuration
					driver.findElement(By.cssSelector(".applications .users .configuration")).click();
					driver.findElement(By.cssSelector(".menu")).click();
					driver.findElement(By.cssSelector(".wrapper .active .space li:nth-child(4) .active")).click();
		
	}
	
	
}
