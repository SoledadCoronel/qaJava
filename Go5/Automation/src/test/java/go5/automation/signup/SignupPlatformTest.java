package go5.automation.signup;


import go5.automation.TestSuite;
import go5.pageObjects.ProfilePage;
import go5.pageObjects.SignupPlatformPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class SignupPlatformTest extends TestSuite{

	private String email = this.generateRandomEmail();
	SignupPlatformPage platform =null;
	
	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
		 	
		 	driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         Reporter.log("Abriendo el formulario de signup de plataforma");					 
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
 		 platform = new SignupPlatformPage(driver);  
 		 
		
		 driver.switchTo().frame("iframe");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		log.info(" Loading signup page");
		platform.createPlatformEspanish(email);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		log.info("Submit form and get token to create platform");
		
		// Get the token
		String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("href"));
		log.info(urlToken);
		driver.findElement(By.id("create_platform_link")).click();
		return  urlToken;
		     	
	}
 	 @Test (priority=1)
	 // Verify that the language is being changed when you select the different languages
	 
	 public void validateLabelAllLanguages(){
		
		 org.apache.log4j.BasicConfigurator.configure();
		 
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.switchTo().frame("iframe");
		 log.info("Verificando que la pagina de  singup cambia los lenguages");
		
		 //Select Spanish language
		  this.selectLanguage("Spanish");
		 //Get validation
		  
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 log.debug(SpanishText);
		  Assert.assertEquals(SpanishText,"Completa la siguiente información para obtener tu propia plataforma de GOintegro.");
		 
		 //Select Portuguese language
		
		 this.selectLanguage("Portuguese");		 
		  // Get Validation 
		 String PortugueseText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		  log.debug(PortugueseText);
		 Assert.assertEquals(PortugueseText,"Preencha as seguintes informações para sua própria plataforma GOintegro.");
		 
		 //Select English language
		 
		 this.selectLanguage("English");
		 // Get validation message
		 
		 String EnglishText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 log.debug(EnglishText);
		 Assert.assertEquals(EnglishText, "Complete the following information for your own platform GOintegro.");
	 }
	
	
	@Test(priority=2)
	 // Verify the email validations
	 
	 public void verifyIncompleteMailAllLanguages(){
		
		 
		driver.findElement(By.id("SignupRequest_email")).clear();
		driver.findElement(By.id("SignupRequest_email")).sendKeys("mailcorporativo1113");
		 //Select Spanish language
		 this.selectLanguage("Spanish");
		 //Validate error 
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(SpanishText);
		 
		 //Select Language
		 this.selectLanguage("Portuguese");
		 //Validate error 
		 String PortugueseText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(PortugueseText);
		 
		//Select Language
		 this.selectLanguage("English");
		 //Validate error 
		 String EnglishText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(EnglishText);
		 
		 		
	 }
	@Test (priority=3)
	public void validateCorporativeMail(){
		// Select language
		this.selectLanguage("Spanish");
		driver.findElement(By.id("SignupRequest_email")).clear();
		driver.findElement(By.id("SignupRequest_email")).sendKeys("zaraza@hotmail.com");
		//Validate error spanish
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(SpanishText);
		 driver.findElement(By.id("SignupRequest_email")).clear();
		 driver.findElement(By.id("SignupRequest_email")).sendKeys("chumbiba@gmail.com");
		//Validate error spanish
		 String SpanishText2 = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(SpanishText2);
	}
	 
		
	@Test (priority=4)
	
	public void registerMail(){
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.findElement(By.id("SignupRequest_email")).clear();
	this.insertEmail(email);
	this.selectLanguage("Spanish");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.id("submit_button")).submit();
	String emailSent = new String(driver.findElement(By.cssSelector(".signup .message")).getText());
	log.info(emailSent);
	}
	
	
	@Test (priority=5)
		public void validatealreadyregistered() throws Exception { 
		
	 	     			
		    
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.id("SignupRequest_email")).clear();
			this.insertEmail(email);
			this.selectLanguage("Spanish");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String pending=new String(driver.findElement(By.cssSelector(".errormessage a ")).getText());
	        System.out.println(pending);
	       Reporter.log(pending);
	 		}
       
@Test (priority=6)
        public void resendEmail(){
	    driver.findElement(By.cssSelector(".signup .errormessage a ")).click();
}
}