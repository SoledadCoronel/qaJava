package go5.automation.signup;




import go5.automation.TestSuite;
import go5.pageObjects.CreatePlatformPage;
import go5.pageObjects.LoginPage;
import go5.pageObjects.SignupPage;
import go5.pageObjects.SignupPlatformPage;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreatePlatformExpiredToken extends TestSuite{
			
	CreatePlatformPage platform=null;
	

	 @BeforeTest // call function to open the browser and load url
	 public void setup () throws Exception{
	//Abrir la pagina con el token expirado
	 }
		
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }
	 
 
	
 	
 	 @Test (description=" Tratar de abrir la pagina de crear plataforma con un token vencido")
 
 	  	 
 	 public void createPlatformwithExpiredToken() throws Exception { 
 	
 		  		
		
		// WebElement compania = wait.until(ExpectedConditions.elementToBeClickable(By.id("CreateAccount_company")));
		
 	  	 }
 	 	 }
	
	
	