package Go5.Automation;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class LoginTest extends CommonFunctions{

	
	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSite();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	
	@Test
	public void login() throws Exception { 
	
 	     driver.findElement(By.cssSelector("input[id=SignupRequest_email]")).sendKeys("dddd");
        driver.findElement(By.id("SignupRequest_email")).sendKeys("zaraza");
        driver.findElement(By.id("submit_button")).click();
 
	}

	
}
