package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class ForgotPasswordTest extends SignUp{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteLogin();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=1)
	
	public void openForgotPasswordPage(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Validating resending password");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".signup .link")).click();
		
		driver.findElement(By.cssSelector(".primary")).isEnabled();
		log.info(" Buttom to resend is enabled");
			
	}
	@Test(priority=2)
	
	public void insertEmailToResendPassword() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   log.info("Insert email and press button to resend password");
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
		 log.info(SpanishText);
		 System.out.println(SpanishText);
		 Assert.assertEquals(SpanishText,"Revisa tu email.");
 
	}

	
}
