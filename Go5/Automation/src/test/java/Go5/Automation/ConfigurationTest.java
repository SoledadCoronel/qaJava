package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ConfigurationTest extends CommonFunctions{


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
	public void GoToConfiguration(){
		 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Ir a  Configuration menu");
		
		// Go to the configuration
				driver.findElement(By.cssSelector(".applications .users .configuration")).click();
	}
		
}
