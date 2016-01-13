package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
;


public class ForgotPasswordEnglishTest extends SignUp{


	 @BeforeClass // call function to open the browser and load url
	 public void setup (){
	   this.openSiteEnglish();
	 }
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=1)
	
	public void openForgotPasswordPageEnglish(){
		 org.apache.log4j.BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Validating resending password in English");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".signup .link")).click();
		
		driver.findElement(By.cssSelector(".primary")).isEnabled();
		log.info(" Buttom to resend password is enabled ");
	}		
	
	@Test(priority=3)
	
	public void insertEmailToResendPasswordEnglish() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   log.info("Insert email and press button to resend password");
	   String sentMessage = new String (driver.findElement(By.cssSelector(".overlayloading p")).getText());
	   log.info(sentMessage);
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   String SpanishText = new String( driver.findElement(By.cssSelector(".signup h2")).getText());
		 log.info(SpanishText);
		 Assert.assertEquals(SpanishText,"Check your email.");
 
	}

	
	
	@Test(priority=2)
	
	public void insertInvalidEmailEnglish() throws Exception { 
	
 	  	
		driver.findElement(By.id("signInIdentification")).clear();
		driver.findElement(By.id("signInIdentification")).sendKeys("banana@cachirula.zunga.com");
	   driver.findElement(By.cssSelector(".primary")).click();
	   log.info("Insert invalid email and verify that a proper message is displayed in Portuguese");
	   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   String SpanishText2 = new String( driver.findElement(By.cssSelector(".signup .reject ")).getText());
		 log.info(SpanishText2);
		 System.out.println(SpanishText2);
		 Assert.assertEquals(SpanishText2,"The entered email is not registered. Please try again");
 
	}
     }

