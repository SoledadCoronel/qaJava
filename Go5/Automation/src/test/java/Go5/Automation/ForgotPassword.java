package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ForgotPassword extends CommonFunctions{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteLogin();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	 @Test(priority=1)
	public void validatePage(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".link")).click();
			
	}
		
}
