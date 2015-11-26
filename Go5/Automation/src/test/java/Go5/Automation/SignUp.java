package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class SignUp extends CommonFunctions{

	private String email = this.generateRandomEmail();
	
	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteSignUp();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }
	 
 private void insertEmail (String email){
		 
	  driver.findElement(By.id("SignupRequest_email")).clear(); 
	  driver.findElement(By.id("SignupRequest_email")).sendKeys(email);
 }
 
		 public String signup() throws Exception { 
	 	    
		org.apache.log4j.BasicConfigurator.configure();	 
		 driver.switchTo().frame("iframe");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		log.info(" Loading signup page");
		this.insertEmail(email);
		driver.findElement(By.id("SignupRequest_language_0")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.id("submit_button")).submit();
		log.info("Submit form and get token to create platform");
		String emailSent = new String(driver.findElement(By.cssSelector(".signup .message")).getText());
		log.info(emailSent);
		// Get the token
		String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("href"));
		log.info(urlToken);
		driver.findElement(By.id("create_platform_link")).click();
		return  urlToken;
		     	
	}

}
