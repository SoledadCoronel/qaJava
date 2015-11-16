package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class SignUpTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteSignUp();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	
	@Test
	public void signup() throws Exception { 
	
 	     
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().frame("NEED TO ADD ID TO IFRAME");
		driver.findElement(By.id("SignupRequest_email")).clear();
		driver.findElement(By.id("SignupRequest_email")).sendKeys("mailcorporativo@gointegro.com");
        driver.findElement(By.id("submit_button")).click();
 
	}

	
}
