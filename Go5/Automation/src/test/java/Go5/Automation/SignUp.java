package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class SignUp extends CommonFunctions{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteSignUp();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }
	 
	 	 
	public String signup() throws Exception { 
	 	    
				 
		 driver.switchTo().frame("iframe");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.id("SignupRequest_email")).clear();
		driver.findElement(By.id("SignupRequest_email")).sendKeys("marina.touceda@gointegro.com");
		driver.findElement(By.id("SignupRequest_language_0")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.id("submit_button")).submit();
		String emailSent = new String(driver.findElement(By.cssSelector(".signup .message")).getText());
		System.out.println(emailSent);
		// Get the token
		String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("target"));
		log.info(urlToken);
		return  urlToken;
		
	}

}
