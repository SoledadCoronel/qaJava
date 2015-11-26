package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class SignUpTest extends CommonFunctions{

	// declare email as variable in order to be changed
	
	private String email = this.generateRandomEmail();
	

	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteSignUp();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }
	
	
   // Function to select the 3 available languages
	 public void selectLanguage(String language){
		 if (language =="Spanish"){
			 driver.findElement(By.id("SignupRequest_language_0")).click();
		 }
		 else if (language=="English"){
			 driver.findElement(By.id("SignupRequest_language_2")).click();			 
		 }
		 else if (language=="Portuguese"){
			 driver.findElement(By.id("SignupRequest_language_1")).click();
			 }
 	 }
	 
	 private void insertEmail (String email){
		 
		 driver.findElement(By.id("SignupRequest_email")).sendKeys(email);
	 }

	 @Test (priority=1)
	 // Verify that the language is being changed when you select the different languages
	 
	 public void validateLabelAllLanguages(){
		
		 org.apache.log4j.BasicConfigurator.configure();
		 
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.switchTo().frame("iframe");
		 log.info("Verifying singup page changes the language");
		
		 //Select Spanish language
		  this.selectLanguage("Spanish");
		 //Get validation
		  
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 log.debug(SpanishText);
		 System.out.println(SpanishText);
		 Assert.assertEquals(SpanishText,"Completa la siguiente información para obtener tu propia plataforma de GOintegro");
		 
		 //Select Portuguese language
		
		 this.selectLanguage("Portuguese");		 
		  // Get Validation 
		 String PortugueseText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 System.out.println(PortugueseText);
		 log.debug(PortugueseText);
		 Assert.assertEquals(PortugueseText,"Preencha as seguintes informações para sua própria plataforma GOintegro");
		 
		 //Select English language
		 
		 this.selectLanguage("English");
		 // Get validation message
		 
		 String EnglishText = new String( driver.findElement(By.cssSelector(".signup p")).getText());
		 System.out.println(EnglishText);
		 log.debug(EnglishText);
		 Assert.assertEquals(EnglishText, "Complete the following information for your own platform GOintegro");
	 }
	
	
	@Test(priority=2)
	 // Verify the email validations
	 
	 public void verifyIncompleteMailAllLanguages(){
		
		 
		 driver.findElement(By.id("SignupRequest_email")).sendKeys("mailcorporativo1113");
		 //Select Spanish language
		 this.selectLanguage("Spanish");
		 //Validate error 
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(SpanishText);
		 System.out.println(SpanishText);
		 //Select Language
		 this.selectLanguage("Portuguese");
		 //Validate error 
		 String PortugueseText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(PortugueseText);
		 System.out.println(PortugueseText);
		//Select Language
		 this.selectLanguage("English");
		 //Validate error 
		 String EnglishText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(EnglishText);
		 System.out.println(EnglishText);
		 		
	 }
	@Test (priority=3)
	public void validateCorporativeMail(){
		// Select language
		this.selectLanguage("Spanish");
		driver.findElement(By.id("SignupRequest_email")).sendKeys("zaraza@hotmail.com");
		//Validate error spanish
		 String SpanishText = new String( driver.findElement(By.cssSelector(".signup .errormessage")).getText());
		 log.debug(SpanishText);
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
	System.out.println(emailSent);
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
	        Assert.assertEquals(pending, "El email que ingresaste está pendiente de validación. Reenvia el email.");
	 		}
       
@Test (priority=6)
        public void resendEmail(){
	    driver.findElement(By.cssSelector(".signup .errormessage a ")).click();
	    
	    
}
}
