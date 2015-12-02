package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class CreateAccountTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
		 openSiteAfterCreatePlatforEspanish();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	
		@Test(priority=1)
		public void testCreateAccounthBlankUser() throws Exception { 
		
			
			 org.apache.log4j.BasicConfigurator.configure();
	 	  	log.info("Try to Create Account with blank user, verify that the button to submit remains unavailable ");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			if (atrButton == "primary inactive"){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
			}
	
		@Test(priority=2)
		public void createAccounthoutDomainSpanish() throws Exception { 
		
			
			
	 	  	log.info("Validate invalid email in Spanish, button remains unavailable");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			driver.findElement(By.id("SignupRequest_email")).sendKeys("WITHOUTDOMAIN");
			this.selectLanguage("Spanish");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			String spanishmessage = new String (driver.findElement(By.cssSelector(".errormessage")).getText());
			log.info(spanishmessage);
			Assert.assertEquals(spanishmessage,"El email ingresado es inválido.");
			String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			if (atrButton == "primary inactive"){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
			}
		
		@Test(priority=3)
		public void createAccounthWithoutDomainPortuguese() throws Exception { 
		
			
			
	 	  	log.info("Validate incorrect email in Portuguese,button remains unavailable ");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			driver.findElement(By.id("SignupRequest_email")).sendKeys("WITHOUTDOMAIN");
			this.selectLanguage("Portuguese");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			String portuguesemessage = new String (driver.findElement(By.cssSelector(".errormessage")).getText());
			log.info(portuguesemessage);
			Assert.assertEquals(portuguesemessage,"O e-mail digitado é inválido");
			String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			if (atrButton == "primary inactive"){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
			}
		
		@Test(priority=4)
		public void ceateAccounthWithoutDomainEnglish() throws Exception { 
		
			org.apache.log4j.BasicConfigurator.configure();
			 
	 	  	log.info("Validate incorrect email in English, button remains unavailable ");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			driver.findElement(By.id("SignupRequest_email")).sendKeys("WITHOUTDOMAIN");
			this.selectLanguage("English");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			String englishmessage = new String (driver.findElement(By.cssSelector(".errormessage")).getText());
			log.info(englishmessage);
			Assert.assertEquals(englishmessage, "The entered email is invalid.");
			Boolean submitEnable= new Boolean(driver.findElement(By.id("submit_button")).isEnabled());
			//String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			log.info(submitEnable);
			if (submitEnable==true){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
			
		}
		
		@Test(priority=5)
		public void ceateAccounthWithoutCorporativeDomainSpanish() throws Exception { 
		
			
			 
	 	  	log.info("Validate mail entered is not corporative, button remains unavailable,message displayed in Spanish");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			driver.findElement(By.id("SignupRequest_email")).sendKeys("nanu@gmail.com");
			this.selectLanguage("Spanish");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			String englishmessage = new String (driver.findElement(By.cssSelector(".errormessage")).getText());
			log.info(englishmessage);
			Assert.assertEquals(englishmessage,"El email ingresado no es un email corporativo.");
			String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			if (atrButton == "primary inactive"){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
			}
 
		@Test(priority=6)
		public void ceateAccounthWithoutCorporativeDomainPortuguse() throws Exception { 
		
			
	 	  	log.info("Validate mail entered is not corporative, button remains unavailable, message displayed in Portuguese ");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			driver.findElement(By.id("SignupRequest_email")).sendKeys("nanu@gmail.com");
			this.selectLanguage("Portuguese");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			String englishmessage = new String (driver.findElement(By.cssSelector(".errormessage")).getText());
			log.info(englishmessage);
			Assert.assertEquals(englishmessage,"O e-mail inserido não é um e-mail corporativo");
			String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			if (atrButton == "primary inactive"){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
				}
 
		
		@Test(priority=5)
		public void ceateAccounthWithoutCorporativeDomainEngish() throws Exception { 
		
			
			
	 	  	log.info("Validate mail entered is not corporative, button remains unavailable,message displayed in English ");
					
			driver.findElement(By.id("SignupRequest_email")).clear();
			driver.findElement(By.id("SignupRequest_email")).sendKeys("nanuuuuuuuu@gmail.com");
			this.selectLanguage("English");
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			String englishmessage = new String (driver.findElement(By.cssSelector(".errormessage")).getText());
			log.info(englishmessage);
			Assert.assertEquals(englishmessage,"The email entered is not a corporate email");
			String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
			if (atrButton == "primary inactive"){
				log.info("The login button is enabled");
			}
			else
					log.info("The GO! button is disabled");
				
		}
 
	}
	


	


	


	


