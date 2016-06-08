package go5.automation.signup;


import java.util.concurrent.TimeUnit;

import go5.automation.TestSuite;
import go5.pageObjects.CreatePlatformPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class CreatePlatformTest extends TestSuite{

	private String email = this.generateRandomEmail();
	private String companyName= this.generateName();
	private String subdomainName=this.generateName();		
	CreatePlatformPage pl=null;
	
	 @BeforeTest // call function to open the browser and load url
	 public void setup () throws Exception{
		 	
		 	this.setUpMavenSignup();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
	 }
	 
 
	
 	
 	 @Test (description=" Ingreso el mail en signup, clickeo en plataforma y me resgistro")
 
 	  	 
 	 public void createPlatform() throws Exception { 
 		
 		 pl= new CreatePlatformPage(driver);
 		
 		 Reporter.log("Abro la pagina de Ingresar mail y elegir idioma"); 
		signup.createPlatformEspanish(email);
		Reporter.log("Clickeo en el link para abrir la pagina de crear plataforma");
		// Get the token
		String urlToken =new String(driver.findElement(By.id("create_platform_link")).getAttribute("href"));
		Reporter.log(urlToken);
		driver.findElement(By.id("create_platform_link")).click();
		Thread.sleep(4000);
		 Reporter.log( "Ingreso en la pagina del signup de platform");
	//	WebElement compania=driver.findElement(By.id("CreateAccount_company"));  
		Thread.sleep(360000);
		// WebElement compania = wait.until(ExpectedConditions.elementToBeClickable(By.id("CreateAccount_company")));
	 	//Reporter.log("Imprimir si el campo compania se muestra",compania.isDisplayed());	
	 		Reporter.log(driver.getPageSource());

    	 Thread.sleep(10000);
    	
		 pl.registrarse(companyName);
		 
		  
 	 }
 	 
	 }
	
	
	