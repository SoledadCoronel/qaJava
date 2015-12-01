package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class LoginTest extends CommonFunctions{


	 @BeforeClass // call function to open the browser and load url
	 public void setup (){
	   openSiteLogin();
	 }
	
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	@Test(priority=3)
	public void validatePage(){
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Validating login page");
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
		driver.findElement(By.id("signInPassword")).sendKeys("Auto1234");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".link"));
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("The login button is enabled");
		}
		else
				log.info("The login button is disbled");
		
			
	}
	@Test(priority=4)
	public void testProperLogin() throws Exception { 
	
 	  	log.info("Try a login");
		this.login("marina.touceda@gointegro.com","Auto1234");
		log.info("Login successfull");
 
	}
	
	@Test(priority=1)
	public void testLoginWithBlankUser() throws Exception { 
	
		
		 org.apache.log4j.BasicConfigurator.configure();
 	  	log.info("Try a login with blank user ");
		this.login("  ","Auto1234");
		// Verify if the button is disabled 
		
		
		Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
		if (goButtonEnabled == true){
			log.info("The login button is enabled");
		}
		else
				log.info("The login button is disbled");
	
		log.info("Login fails due to user blank");
	}
	
	@Test(priority=2)
	public void testLoginWithBlankPassword() throws Exception { 
	
		org.apache.log4j.BasicConfigurator.configure();
 	  	log.info("Try a login with blank password");
		this.login("marina.touceda@gointegro.com"," ");
		// Verify if the button is disabled 
		
		String atrButton = new String (driver.findElement(By.cssSelector(".primary")).getCssValue(".primary"));
		if (atrButton == "primary inactive"){
			log.info("The login button is enabled");
		}
		else
				log.info("The login button is disbled");
		
		log.info("Login fails due to password in  blank");
	}
}

