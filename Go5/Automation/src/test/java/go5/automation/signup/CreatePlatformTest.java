package go5.automation.signup;


import go5.automation.TestSuite;
import go5.pageObjects.CreatePlatformPage;

import go5.pageObjects.SignupPlatformPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class CreatePlatformTest extends TestSuite{

	private String email = this.generateRandomEmail();
	SignupPlatformPage signup =null;
	CreatePlatformPage pl=null;
	
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
	
 	public void signup() throws Exception { 
 		 signup = new SignupPlatformPage(driver);  
 		 pl= new CreatePlatformPage(driver);
 		 
		org.apache.log4j.BasicConfigurator.configure();	 
		 driver.switchTo().frame("iframe");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		log.info(" Loading signup page");
		signup.createPlatformEspanish(email);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		log.info("Submit form and get token to create platform");
		
		// Get the token
		String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("href"));
		log.info(urlToken);
		driver.findElement(By.id("create_platform_link")).click();
		Thread.sleep(5000);
		     	
	}
 	 @Test (description=" Ingreso el mail en signup, clickeo en plataforma y me resgistro")
 
 	  	 
  	 
	 public void createPlatform() throws Exception{
		
		 Reporter.log( "Ingreso en signup");
		 //Generar un random name and subdomain
		 pl.registrarse("gointegro", "automation7");
		 
		  
 	 }
 	 
	 }
	
	
	